package net.javaguides.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.school.entity.Course;
import net.javaguides.school.entity.Teacher;
import net.javaguides.school.service.TeacherService;

@RestController
public class TeacherController {
	
	 	@Autowired
	    private TeacherService teacherService;
	    
	    @PostMapping("/teacher")
	    public Teacher saveTeacher(@RequestBody Teacher teacher) {
	    	Teacher teacherResponse = teacherService.saveTeacher(teacher);
	    	
//	    	List<Course> course = teacher.getCourses();
//	    	
//	    	teacherResponse.setCourses(course);
	    	
	        return teacherResponse;
	    }
}
