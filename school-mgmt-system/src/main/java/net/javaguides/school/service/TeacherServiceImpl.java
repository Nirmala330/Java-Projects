package net.javaguides.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.school.entity.Course;
import net.javaguides.school.entity.Teacher;
import net.javaguides.school.repository.CourseRepository;
import net.javaguides.school.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;
	
	
	
	@Override
	public Teacher saveTeacher(Teacher teacher) {
		
		return teacherRepository.save(teacher);
	}

}
