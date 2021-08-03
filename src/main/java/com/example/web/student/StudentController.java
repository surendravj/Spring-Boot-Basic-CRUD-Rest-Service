package com.example.web.student;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentSerivce) {
		this.studentService=studentSerivce;
	}
	
	@GetMapping()
	public List<Student> student()
	{
		return studentService.getStudent();
	}
	
	@PostMapping()
	public Map<String,Boolean> Add(@RequestBody Student student)
	{
		return studentService.addStudent(student);
	}
	
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long id)
	{
		
		studentService.deleteStudent(id);
	}
	
	@PutMapping(path="{studentId}")
	public void updateStudent(@PathVariable("studentId") Long id,@RequestParam(required = false) String name,@RequestParam(required = false) String email)
	{
		studentService.updateStudent(id, name, email);
	}
	
}
