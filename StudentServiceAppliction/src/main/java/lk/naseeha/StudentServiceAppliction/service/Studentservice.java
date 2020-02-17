package lk.naseeha.StudentServiceAppliction.service;

import java.util.List;
import java.util.Optional;

import lk.naseeha.StudentServiceAppliction.model.Student;


public interface Studentservice {

	public Student save (Student stu);
	
	public Optional<Student> findById(int id);
	
	public Student fetchAllAllocations(int studentid);
	
	public List<Student> getAllStudent();
	
	
}
