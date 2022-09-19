package net.javaguides.sms.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name =  "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))

public class User {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	
	@Column(name = "first_name" , nullable = false)
	@NotEmpty(message = "First Name field should not be empty")
	@Size(min = 2, max = 10, message = "length shoud be in between 2 to 10")
	private String firstName;

	
	@Column(name = "last_name" ,  nullable = false)
	@NotEmpty(message = "Last Name field should not be empty")
	@Size(min = 2, max = 10, message = "length shoud be in between 2 to 10")
	private String lastName;
	
	@Column(name = "email")
	@NotEmpty(message = "Email field should not be empty")
	@Email(regexp = "^(.+)@(.+)$", message = "Invalid email pattern")	 
	private String email;
	
	@Column(name = "mobile")
	@NotEmpty(message = "Mobile field should not be empty")
	@Pattern(regexp = "[7-9][0-9]{9}", message = "invalid mobile number.")
	@Size(max = 10, message = "digits should be 10")
	private String mobile;
	
	@Column(name = "password")
	@NotEmpty(message = "Password field should not be empty")
	@Size(min=8 , message = "Password should have atleast 8 chars")
	private String password;
		
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
		            name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "role_id", referencedColumnName = "id"))

	private Collection<Role> roles;

	
	public User(String firstName, String lastName,String email,String mobile, String password,Collection<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}


}
