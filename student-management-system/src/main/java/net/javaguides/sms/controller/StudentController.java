
package net.javaguides.sms.controller;


import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;


@Controller
public class StudentController {


	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@GetMapping("/navbar")
	public String navbar() {
		return "navbar";
	}
	
	
	
	
	// handler method to handle list students and return mode and view
	@GetMapping("/")
	public String listStudents(Model model) {
		
		return listStudentsByPage(model , 1 , "name" , "asc");
		
	}
	
	@GetMapping("/page/{pageNumber}")
	public String listStudentsByPage(Model model ,
			@PathVariable("pageNumber") int currentPage,
			@Param("sortField") String sortField,
			@Param("sortDirection") String sortDirection
			) 
		{
		
		Page<Student> page = studentService.getAllStudents(currentPage,sortField,sortDirection);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		
		List<Student> listStudents = page.getContent();
		model.addAttribute("currentPage", currentPage);

		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("students", listStudents);
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDirection", sortDirection);
		
		String reverseSortDirection = sortDirection.equals("asc") ? "desc" :"asc";
		model.addAttribute("reverseSortDirection", reverseSortDirection);

		//model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		// create student object to hold student form data
		
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";

	}

	@PostMapping("/students")
	public String saveStudent(@RequestParam("file") MultipartFile file,@ModelAttribute("student") Student student) throws IOException {
		
		  String fileName = file.getOriginalFilename();
		  student.setContent(file.getBytes());
		  student.setSize(file.getSize());
		  student.setImage(fileName);
		  studentService.saveStudent(student);  
		  return "redirect:/";
		 
	}

	@GetMapping("/students/view/{id}")
	public String viewStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "view_student";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/view_students/{id}")
	public String viewStudent(@RequestParam("file") MultipartFile file,@PathVariable Long id,@ModelAttribute("student") Student student,Model model) throws IOException {

		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		String fileName = file.getOriginalFilename();
		existingStudent.setContent(file.getBytes());
		existingStudent.setSize(file.getSize());
		existingStudent.setImage(fileName);

		return "redirect:/";		
	}


	@PostMapping("/update_student/{id}")
	public String updateStudent(@RequestParam("file") MultipartFile file,@PathVariable Long id,@ModelAttribute("student") Student student,Model model) throws IOException {

		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		String fileName = file.getOriginalFilename();
		
		
		if(!fileName.isEmpty()) {
			existingStudent.setContent(file.getBytes());
			existingStudent.setSize(file.getSize());
			existingStudent.setImage(fileName);
		}
		else {
			existingStudent.setImage(student.getImage());

		}


		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/";		
	}

	// handler method to handle delete student request

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/";
	}
	
	 @GetMapping("/image")
	 public void showImage(@Param("id") Long id, HttpServletResponse response,Student student)
	   throws ServletException, IOException {
	  
	  student = studentService.getStudentById(id);
	  response.getOutputStream().write(student.getContent());		  
	  response.getOutputStream().close();
	 }
	 
	
	 @GetMapping("/downloadfile")
	 public void downloadFile(@Param("id") Long id , Model model, HttpServletResponse response) throws IOException {
	  Student temp = studentService.getStudentById(id);
	  if(temp!=null) {
	   Student student = temp;
	   response.setContentType("application/octet-stream");
	   String headerKey = "Content-Disposition";
	   String headerValue = "attachment; filename = "+student.getImage();
	   response.setHeader(headerKey, headerValue);
	   ServletOutputStream outputStream = response.getOutputStream();
	   outputStream.write(student.getContent());
	   outputStream.close();
	  }
	  
	}
}
	 
