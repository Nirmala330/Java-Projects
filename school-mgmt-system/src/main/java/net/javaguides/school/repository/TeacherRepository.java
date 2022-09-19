package net.javaguides.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.school.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	
}

