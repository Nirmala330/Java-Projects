package net.javaguides.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.school.entity.Course;
import net.javaguides.school.entity.CourseMaterial;
import net.javaguides.school.service.CourseMaterialService;
import net.javaguides.school.service.CourseService;

@RestController
public class CourseController {
	
    @Autowired
    private CourseService courseService;
    
   
    
    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course) {
    	Course courseResponse = courseService.saveCourse(course);
    	courseResponse.setTeacher(course.getTeacher());
    	
        return courseResponse;
    }
    
    @GetMapping("/course")
    public List<Course> findAllcourses() {

        return courseService.getCourses();
    }
    
    @GetMapping("/courseById/{courseId}")
    public Course findCourseById(@PathVariable Long courseId) {
        return courseService.findCourseById(courseId);
    }
    
    @GetMapping("/course/filter/{title}")
    public List<Course> findByCourseTitle(@PathVariable String title) {
        return courseService.findByCourseTitle(title);
    }
    
    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }
    


}
