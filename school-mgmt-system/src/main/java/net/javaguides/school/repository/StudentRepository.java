package net.javaguides.school.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.school.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	public List<Student> findByFirstName(String firstname);
	
	public List<Student> findByFirstNameContaining(String firstname);
 
	public List<Student> findByLastNameNotNull();
	
	public List<Student> findByGuardianName(String guardian_name);
	
	
	//JPQL Query : In this Query ,  Class Name is used instead of table name and column name.
	// AS in Native SQL Query we use table names and column names for writing Queries.
	
	@Query("select s.firstName from Student s where s.emailId = ?1")
	public String getStudentFirstNameByEmailId(String emailId);
	
	
	//Native Query
	@Query(
			value 			= 	"SELECT * FROM student_tbl s where s.email_id = ?1",
			nativeQuery 	= 	true)
	
	public Student getStudentByEmailIdNative(String emailId);
	
	

	//Native Named Query
	@Query(
			value 			= 	"SELECT * FROM student_tbl s where s.email_id = :emailId",
			nativeQuery 	= 	true
		  )
	
	public Student getStudentByEmailIdNativeNamedParam(@Param("emailId") String emailId);


	@Modifying
	@Transactional
	@Query(
			value 			= 	"UPDATE student_tbl SET first_name = ?1 where email_id = ?2",
			nativeQuery 	= 	true
		  )
	
	public int updateStudentNameByEmailId(String firstName , String emailId);
	
}
