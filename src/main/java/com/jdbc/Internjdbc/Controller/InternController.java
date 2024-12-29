package com.jdbc.Internjdbc.Controller;

import com.jdbc.Internjdbc.Entity.Intern;
import com.jdbc.Internjdbc.Service.InternService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/api/intern")
public class InternController {
    @Autowired
    private InternService internService;
    
    @GetMapping("/")
	public String home()
	{
		return "index";
	}
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	@GetMapping("/getAll")
	public String getAll()
	{
		return "getAll";
	}
	@GetMapping("/update")
	public String update()
	{
		return "update";
	}
    @GetMapping("/delete")
    public String delete()
    {
    	return "delete";
    }
    
    @PostMapping
    public String addintern(@RequestBody Intern intern)
    {
        internService.addInterns(intern);
//        log.info("Added");
        return "Intern Added Sucessfully";
    }
    @GetMapping("/{id}")
    public Intern getbyid(@PathVariable  int id)
    {
//        log.info("Getted by id");
    	
//    	session.setAttribute("intern",Intern);
        return internService.getInternById(id);
    }
    @GetMapping()
    public List<Intern> getallintern(HttpSession session)
    {
//        log.info("Get all intern");
    	List<Intern> findAll = internService.getAllIntern();
    	session.setAttribute("findAll", findAll);
        return findAll ;
    }
    @PutMapping("/{id}")
    public int updateIntern(@PathVariable int id, @RequestBody Intern intern)
    {
//        log.info("edited intern");
        intern.setPid(id);
        int i1 = internService.updateInterns(intern);
        return i1;
    }
    @DeleteMapping("/{id}")
    public String deleteintern(@PathVariable String id)
    {
//        log.info("deleted intern");
        internService.deleteIntern(id);
        return "Intern Deleted Sucessfully";
    }
    
    @PutMapping("/delete/{id}")
    public String deleteRecord(@PathVariable String id, @RequestBody String action)
    {
    	if("delete".equalsIgnoreCase(action))
    	{
    		internService.deleteByputmapping(id);
    		return "deleted using putmapping";
    	}
    	return "Not deleted";
    }


}
