package net.javaguides.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.school.entity.CourseMaterial;
import net.javaguides.school.entity.Student;
import net.javaguides.school.repository.CourseMaterialRepository;

@Service
public class CourseMaterialServiceImpl implements CourseMaterialService {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

	@Override
	public CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial) {
		
		return courseMaterialRepository.save(courseMaterial);
	}

	@Override
	public CourseMaterial findCourseMaterialByCourseId(Long courseId) {
		
		return courseMaterialRepository.findCourseMaterialByCourseId(courseId);
		
	}

	
}
