package com.jdbc.Internjdbc.Service;

import com.jdbc.Internjdbc.Entity.Intern;
import com.jdbc.Internjdbc.Repo.InternRepo;
import com.jdbc.Internjdbc.Repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.relational.core.sql.StatementBuilder.update;
@Service
public class InternService  {

    @Autowired
    private Repo internrepo;

    public void addInterns(Intern intern) {
        internrepo.saveIntern(intern);
    }

    public Intern getInternById(int id) {
        return internrepo.findById(id);
    }

    public List<Intern> getAllIntern() {
        return internrepo.findAll();
    }

    public int updateInterns(Intern intern) {
        return internrepo.update(intern);
    }

    public void deleteIntern(String id) {
        internrepo.deleteById(id);
    }

	public void deleteByputmapping(String id) {
		// TODO Auto-generated method stub
		internrepo.deletetherecord(id);
		
	}
}
