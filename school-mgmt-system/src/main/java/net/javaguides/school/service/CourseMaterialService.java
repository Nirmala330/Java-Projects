package net.javaguides.school.service;

import java.util.List;

import net.javaguides.school.entity.CourseMaterial;

public interface CourseMaterialService {

	CourseMaterial saveCourseMaterial(CourseMaterial courseMaterial);
	
	public CourseMaterial findCourseMaterialByCourseId(Long courseId);
}
