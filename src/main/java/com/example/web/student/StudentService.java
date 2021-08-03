package com.example.web.student;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
	
	private final StudentRepository sr;
	
	@Autowired
	public StudentService(StudentRepository studentRepository)
	{
		this.sr=studentRepository;
	}
	
	public List<Student> getStudent()
	{
		return sr.findAll();		
		
	}
	
	public Map<String,Boolean> addStudent(Student student)
	{
		Optional<Student> findByEmail=sr.findStudentByEmail(student.getEmail()); 
		if(findByEmail.isPresent())
		{
			throw new IllegalStateException("Email already taken");
		}
		sr.save(student);
		Map<String,Boolean> response=new HashMap<>();
		response.put("Saved",true);
		return response;
	}
	
	
	public void deleteStudent(Long id)
	{
		Boolean idExists=sr.existsById(id);
		if(!idExists) {
			throw new IllegalStateException("Unable to find these id");
		}else {
			sr.deleteById(id);
		}
		
	}
	
	@Transactional
	public void updateStudent(Long id,String name,String email)
	{
		Student student=sr.findById(id).orElseThrow(()->new IllegalStateException("Unable to find student with these id"));
		if(name!=null&&name.length()!=0&&!Objects.equals(name, student.getName())) {
			student.setName(name);
		}
		if(email!=null&&email.length()!=0&&!Objects.equals(email, student.getEmail())) {
			Optional<Student> ref=sr.findStudentByEmail(email);
			if(ref.isPresent()) {
				throw new IllegalStateException("Email already taken");
			}else {
				student.setEmail(email);
			}
		}
	}
	
}
