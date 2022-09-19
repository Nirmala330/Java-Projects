package net.javaguides.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.school.entity.Course;
import net.javaguides.school.entity.CourseMaterial;
import net.javaguides.school.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

   
    public Course saveCourse(Course course) {
        CourseMaterial courseMaterial = course.getCourseMaterial();
                
        courseMaterial.setCourse(course);
        return courseRepository.save(course);  
        
    }


	@Override
	public List<Course> getCourses() {
		return courseRepository.findAll();
	}


	@Override
	public Course findCourseById(Long courseId) {
		return courseRepository.findById(courseId).orElse(null);
	}


	@Override
	public List<Course> findByCourseTitle(String title) {
		return courseRepository.findByTitle(title);
	}

	
	@Override
	public Course updateCourse(Course course) {
		Course existingCourse = courseRepository.findById(course.getCourseId()).get();
		existingCourse.setTitle(course.getTitle());
		existingCourse.setCredit(course.getCredit());
        return courseRepository.save(existingCourse);
    }


	
}
