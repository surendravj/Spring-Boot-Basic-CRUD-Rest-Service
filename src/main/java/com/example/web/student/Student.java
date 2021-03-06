package com.example.web.student;



import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;




@Entity
@Table
public class Student {
	
	@Id
	@SequenceGenerator(name = "student_sequence",sequenceName = "student_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_sequence")
	private Long id;
	private String name;
	private LocalDate dob;
	private String email;
	@Transient
	private int age;
	
	
	public Student() {
		
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}
	
	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob + ", email=" + email + ", age=" + age
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getDob()=" + getDob() + ", getEmail()="
				+ getEmail() + ", getAge()=" + getAge() + "]";
	}
	
	
	
	


	public Student(String name, LocalDate dob, String email) {
		super();
		this.name = name;
		this.dob = dob;
		this.email = email;
	}
	
	

}
