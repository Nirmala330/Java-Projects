package net.javaguides.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import net.javaguides.sms.entity.Student;

public interface StudentService {
	//List<Student> getAllStudents();
	
	Page<Student> getAllStudents(int pageNumber , String sortField , String sortDirection);

	Student saveStudent(Student student);

	Student getStudentById(Long id);

	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);

	
		
	
}