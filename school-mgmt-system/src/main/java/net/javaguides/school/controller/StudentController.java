package net.javaguides.school.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.school.entity.Student;
import net.javaguides.school.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@PostMapping("/students")
	public Student saveStudentWithGuardian(@RequestBody Student student) {
		
		LOGGER.info("Inside SAVA DEPARTMENT METHOD");
		return service.saveStudentWithGuardian(student);	
	}	
	
	
	@GetMapping("/students")
	public List<Student> fetchAllStudentsList() {
		
		LOGGER.info("Inside FETCH ALL DEPARTMENT METHOD");
		return service.fetchAllStudentsList();	
		
	}
	
	@GetMapping("/students/stud_name/{firstName}")
	public List<Student> fetchStudentByFirstName(@PathVariable("firstName") String firstName) {
		LOGGER.info("NAME:" +firstName );
		return service.fetchStudentByFirstName(firstName);		
	}
	
	@GetMapping("/students/search/{firstName}")
	public List<Student> findByFirstNameContaining(@PathVariable("firstName") String firstname) {
		
		return service.findByFirstNameContaining(firstname);		

	}
	
	@GetMapping("/students/guardian_name/{guardianName}")
	public List<Student> findByGuardianNames(@PathVariable("guardianName") String name) {

		return service.findByGuardianName(name);		
	}


	@GetMapping("/students/email_id/{emailId}")
	public String getStudentFirstNameByEmailId(@PathVariable("emailId") String emailId) {

		return service.getStudentFirstNameByEmailId(emailId);		
	}
	
	
	@GetMapping("/students/emailid/{email_id}")
	public Student getStudentByEmailIdNative(@PathVariable("email_id") String emailId) {

		return service.getStudentByEmailIdNative(emailId);		
	}
	
	@GetMapping("/students/emailId/{email_id}")
	public Student getStudentByEmailIdNativeNamedParam(@PathVariable("email_id") String emailId) {

		return service.getStudentByEmailIdNativeNamedParam(emailId);		
	}
	
	@PutMapping("/students/emailId/{email_id}")
	public void updateStudentNameByEmailId(@RequestBody String firstName,
			@PathVariable("email_id")String emailId) {

	   service.updateStudentNameByEmailId(firstName,emailId);	
		
	}


	
	
}
