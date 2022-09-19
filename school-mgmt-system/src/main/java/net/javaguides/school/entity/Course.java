package net.javaguides.school.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.javaguides.school.request.CourseRequest;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Course {
	
//	    @SequenceGenerator(
//	            name = "course_sequence",
//	            sequenceName = "course_sequence",
//	            allocationSize = 1
//	    )
//	    @GeneratedValue(
//	            strategy = GenerationType.SEQUENCE,
//	            generator = "course_sequence"
//	    )
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	    private Long courseId;
	    private String title;
	    private Integer credit;
	    

	    @OneToOne(cascade = CascadeType.ALL, mappedBy = "course")
	 	private CourseMaterial courseMaterial;
	    
	    @ManyToOne(
	            cascade = CascadeType.ALL
	    		)
	    		
	    		@JoinColumn(
	    		        name = "teacher_id",
	    		        referencedColumnName = "teacherId"
	    		)
	    
	    		Teacher teacher;
	    
}
