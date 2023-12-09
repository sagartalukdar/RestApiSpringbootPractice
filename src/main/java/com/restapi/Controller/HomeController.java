package com.restapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.Entity.Student;
import com.restapi.service.StudentService;

@RestController
@RequestMapping("/api/")
public class HomeController {

	@Autowired
	private StudentService ss;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(ss.save(student), HttpStatus.CREATED);
	}
	@GetMapping("/show")
	public ResponseEntity<List<Student>> showAllStudents(){
		return new ResponseEntity<List<Student>>(ss.getAllStudents(), HttpStatus.OK);
	}
	@PutMapping("edit/{id}")
	public ResponseEntity<Student> edit(@PathVariable("id") int id,@RequestBody Student student){
		return new ResponseEntity<Student>(ss.updateStudent(id, student), HttpStatus.OK);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")int id){
		return new ResponseEntity<String>(ss.deleteStudent(id), HttpStatus.OK);
	}
}
