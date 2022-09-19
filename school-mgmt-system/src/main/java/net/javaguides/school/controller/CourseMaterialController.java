package net.javaguides.school.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.school.entity.Course;
import net.javaguides.school.entity.CourseMaterial;
import net.javaguides.school.entity.Student;
import net.javaguides.school.repository.CourseMaterialRepository;
import net.javaguides.school.repository.CourseRepository;
import net.javaguides.school.request.CourseRequest;
import net.javaguides.school.service.CourseMaterialService;

@RestController
public class CourseMaterialController {

	
	 @Autowired
	 private CourseMaterialService courseMaterialService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(CourseMaterialController.class);
	
	@GetMapping("/course/course_id/{courseId}")
	public CourseMaterial findCourseMaterialByCourseId(@PathVariable Long courseId) {

		return courseMaterialService.findCourseMaterialByCourseId(courseId);		
	}
	
}
