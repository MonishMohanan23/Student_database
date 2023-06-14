package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	@PostMapping("/addStudent")
	ResponseEntity<Student> addStudent(@RequestBody Student s)
	{
		return new ResponseEntity<Student>(service.addStudent(s),HttpStatus.CREATED);
	}
	@GetMapping("/studentById")
	ResponseEntity<Student> getById(@RequestHeader Integer sid)
	{
		return new ResponseEntity<Student>(service.getByID(sid),HttpStatus.FOUND);//When we want get data use found
	}
	@GetMapping("/studentByName")
	ResponseEntity<List<Student>> getByStudentName(@RequestHeader String sname)
	{
		return new ResponseEntity<List<Student>>(service.getBySname(sname),HttpStatus.FOUND);
	}
	@GetMapping("/studentByMarks")
	ResponseEntity<List<Student>> getByMarks(@RequestHeader Double marks)
	{
		return new ResponseEntity<List<Student>>(service.getByMarks(marks),HttpStatus.FOUND);
	}
	@PutMapping("/updateStudent")
	ResponseEntity<Student> updateName(@RequestBody Student s )
	{
		return new ResponseEntity<Student>(service.updateStudent(s),HttpStatus.OK);//When we want get data use found
	}
	@DeleteMapping("/deleteStudent")
	void deleteEmployee(@RequestHeader int sid )
	{
		System.out.println(sid+" got deleted from database successfully");
	}
	
	

}

