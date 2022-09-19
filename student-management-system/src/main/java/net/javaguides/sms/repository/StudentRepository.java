package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import net.javaguides.sms.entity.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long>{

}