package com.jdbc.Internjdbc.Repo;

import com.jdbc.Internjdbc.Entity.Intern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository

public class InternRepo implements Repo{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int saveIntern(Intern intern) {
        String sql = "INSERT INTO INTERNBATCH (pid,internname,internid,collegename,batchno,projectname) VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,intern.getPid(),intern.getInternname(),intern.getInternid(),intern.getCollegename(),intern.getBatchno(),intern.getProjectname());
    }

    public Intern findById(int id) {
        String sql = "SELECT * FROM INTERNBATCH WHERE pid = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new InternRowMapper());
    }

    public List<Intern> findAll() {
        String sql = "SELECT * FROM INTERNBATCH";
        return jdbcTemplate.query(sql,new InternRowMapper());
    }

    public int deleteById(String id) {
        String sql = "DELETE FROM INTERNBATCH WHERE internname = ?";
        return jdbcTemplate.update(sql,id);
    }

    public int update(Intern intern) {
        String sql = "UPDATE INTERNBATCH SET pid = ?,internname = ?,internid = ?,collegename = ?,batchno = ?,projectname = ? WHERE pid = ?";
        return jdbcTemplate.update(sql,intern.getPid(),intern.getInternname(),intern.getInternid(),intern.getCollegename(),intern.getBatchno(),intern.getProjectname(),intern.getPid());
    }

    private static class InternRowMapper implements RowMapper<Intern>
    {
        public Intern mapRow(ResultSet rs, int rowNum) throws SQLException {
            Intern intern = new Intern();
            intern.setPid(rs.getInt("pid"));
            intern.setInternname(rs.getString("internname"));
            intern.setInternid(rs.getInt("internid"));
            intern.setCollegename(rs.getString("collegename"));
            intern.setBatchno(rs.getInt("batchno"));
            intern.setProjectname(rs.getString("projectname"));
            return intern;
        }
    }

	public int deletetherecord(String id) {
		String sql = "DELETE FROM INTERNBATCH WHERE internname = ?";
		 return jdbcTemplate.update(sql,id);
		
		// TODO Auto-generated method stub
		
	}
}
