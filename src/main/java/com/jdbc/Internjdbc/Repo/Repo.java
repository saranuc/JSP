package com.jdbc.Internjdbc.Repo;

import com.jdbc.Internjdbc.Entity.Intern;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface Repo {
    int saveIntern(Intern intern);

    Intern findById(int id);

    List<Intern> findAll();

    int update(Intern intern);

    int deleteById(String id);

	int deletetherecord(String id);
}
