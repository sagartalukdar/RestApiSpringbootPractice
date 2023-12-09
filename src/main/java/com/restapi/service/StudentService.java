package com.restapi.service;

import java.util.List;

import com.restapi.Entity.Student;

public interface StudentService {

	public Student save(Student student);
	
	public List<Student> getAllStudents();
	
	public Student updateStudent(int id,Student student);
	
	public String deleteStudent(int id);
	
}
