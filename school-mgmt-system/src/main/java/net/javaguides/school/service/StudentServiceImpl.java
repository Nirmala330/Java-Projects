package net.javaguides.school.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.school.entity.Student;
import net.javaguides.school.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student saveStudentWithGuardian(Student student) {
		return studentRepository.save(student);	
	}

	@Override
	public List<Student> fetchAllStudentsList() {	
		return studentRepository.findAll();		
	}

	@Override
	public List<Student> fetchStudentByFirstName(String firstName) {
		
		return studentRepository.findByFirstName(firstName);		
	}

	@Override
	public List<Student> findByFirstNameContaining(String firstname) {

		return studentRepository.findByFirstNameContaining(firstname);		

	}

	@Override
	public List<Student> findByGuardianName(String guardianName) {

		return studentRepository.findByGuardianName(guardianName);		
	}

	@Override
	public String getStudentFirstNameByEmailId(String emailId) {

		return studentRepository.getStudentFirstNameByEmailId(emailId);		
	}

	@Override
	public Student getStudentByEmailIdNative(String emailId) {

		return studentRepository.getStudentByEmailIdNative(emailId);		
	}

	@Override
	public Student getStudentByEmailIdNativeNamedParam(String emailId) {

		return studentRepository.getStudentByEmailIdNativeNamedParam(emailId);		
	}

	@Override
	public void updateStudentNameByEmailId(String firstname , String emailId){

		studentRepository.updateStudentNameByEmailId(firstname,emailId);				
		
	}

	

//	@Override
//	public List<Student> findByLastNameNotNull() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}
