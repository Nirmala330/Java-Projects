package net.javaguides.school.service;

import java.util.List;

import net.javaguides.school.entity.Course;
import net.javaguides.school.entity.CourseMaterial;

public interface CourseService {

	 public Course saveCourse(Course course);

	public List<Course> getCourses();

	public Course findCourseById(Long id);

	public List<Course> findByCourseTitle(String title);

	public Course updateCourse(Course course);
}
