package net.javaguides.school.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.school.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

	//Page<Course> findByTitleContaining(String title, Pageable pageable);
	
	public List<Course> findByTitle(String title);
	

	
	
}
