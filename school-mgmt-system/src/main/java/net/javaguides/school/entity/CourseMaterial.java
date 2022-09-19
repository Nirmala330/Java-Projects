package net.javaguides.school.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

public class CourseMaterial {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 
	    private Long courseMaterialId;
	    private String url;

	    @OneToOne(cascade = CascadeType.ALL)
	    
	    @JoinColumn(
	            name = "course_id",
	            referencedColumnName = "courseId"
	    )  
	    
	    @JsonBackReference
	    private Course course;
	    

}
