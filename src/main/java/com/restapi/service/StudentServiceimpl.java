package com.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.Entity.Student;
import com.restapi.Repository.StudentRepository;
@Service
public class StudentServiceimpl implements StudentService{

	@Autowired
	private StudentRepository sr;
	@Override
	public Student save(Student student) {
	  Student st=sr.save(student);
	  return st;
	}
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}
	@Override
	public Student updateStudent(int id, Student student) {
		student.setId(id);
		return sr.save(student);
	}
	@Override
	public String deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student st=sr.findById(id).get();
		if(st!=null) {
			sr.delete(st);
			return "deleted";
		}else {
			return "student is null";
		}
	
	}

}
