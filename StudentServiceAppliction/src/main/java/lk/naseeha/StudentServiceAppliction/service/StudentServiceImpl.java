package lk.naseeha.StudentServiceAppliction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lk.naseeha.StudentServiceAppliction.model.Allocation;
import lk.naseeha.StudentServiceAppliction.model.Student;
import lk.naseeha.StudentServiceAppliction.model.Telephone;
import lk.naseeha.StudentServiceAppliction.repository.StudentRepository;

@Service
public class StudentServiceImpl implements Studentservice {

	@Autowired
	StudentRepository studentrepo;

	@Bean
	public RestTemplate getRestTemplate() {
		
		
		return new RestTemplate();
	}
	
	@Autowired
    RestTemplate restTemplate;
	
	public Student save(Student stu) {
		
		for(Telephone tp : stu.getTelephone()) {
			
			tp.setStudent(stu);
		}
		
		
		return studentrepo.save(stu);
	}


	@Override
	public Optional<Student> findById(int id) {
		
		return studentrepo.findById(id);
	}

	@Override
	public Student fetchAllAllocations(int studentid) {
		
		Optional<Student> students = studentrepo.findById(studentid);
		
		if(students.isPresent()) {
			
			Student objstudent = students.get();
			
			
			HttpHeaders httpHeaders = new HttpHeaders();
			
			HttpEntity<String> httpEntity = new HttpEntity<String>("",httpHeaders);
			
			ResponseEntity<Allocation[]> responseEntity =  restTemplate.exchange(
					"http://localhost:1989/allocation/findbyid/"+ studentid, HttpMethod.GET, httpEntity, Allocation[].class);
			
			objstudent.setAllocations(responseEntity.getBody());
			
			//studentrepo.save(objstudent);
			
			return objstudent;
			
		}
		
		return null;
	}


	@Override
	public List<Student> getAllStudent() {
		return studentrepo.findAll();
	}	
	
}
