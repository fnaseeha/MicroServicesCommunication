package lk.naseeha.StudentServiceAppliction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lk.naseeha.StudentServiceAppliction.model.Student;
import lk.naseeha.StudentServiceAppliction.service.Studentservice;

@RestController
public class StudentController {
	
	@Autowired
	Studentservice studentservice;
	
	@RequestMapping("/services")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping(value = "/studentget", method = RequestMethod.GET)
	public List<Student> getAllstudents(){
		
		return studentservice.getAllStudent();
		
	}
	
	@RequestMapping(value= "/student" , method = RequestMethod.POST)
	public Student save(@RequestBody Student stu){
		
          return studentservice.save(stu);
		
	}
	
	@RequestMapping(value = "studentfetch/{Studentid}")
	public Student fetch(@PathVariable int Studentid) {
		
		return studentservice.fetchAllAllocations(Studentid);
		
		
	}
	
}
