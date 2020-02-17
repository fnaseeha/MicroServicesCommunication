package lk.naseeha.StudentServiceAppliction.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import lk.naseeha.StudentServiceAppliction.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	//student save(student stu);

}
