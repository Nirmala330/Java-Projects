package net.javaguides.school.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import net.javaguides.school.entity.Student;

public interface StudentService{

	public Student saveStudentWithGuardian(Student student);
	
	public List<Student> fetchAllStudentsList();
	
	public List<Student> fetchStudentByFirstName(String firstName);

	public List<Student> findByFirstNameContaining(String firstname);

	//public List<Student> findByLastNameNotNull();
	
	public List<Student> findByGuardianName(String guardianName);

	public String getStudentFirstNameByEmailId(String emailId);

	public Student getStudentByEmailIdNative(String emailId);

	public Student getStudentByEmailIdNativeNamedParam(@Param("emailId") String emailId);

	public void updateStudentNameByEmailId(String firstName , String emailId);
}
