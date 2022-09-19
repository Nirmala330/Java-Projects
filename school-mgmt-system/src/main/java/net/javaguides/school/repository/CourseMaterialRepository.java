package net.javaguides.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.school.entity.Course;
import net.javaguides.school.entity.CourseMaterial;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {

	//Native Query
		@Query(
				value 			= 	"SELECT * FROM course_material where course_material.course_id = ?1" ,
				nativeQuery 	= 	true)
		
	public CourseMaterial findCourseMaterialByCourseId(Long courseId);

}
