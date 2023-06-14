package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Student;

public interface StudentService {
	Student addStudent(Student s);
	Student getByID(Integer sid);
	List<Student> getBySname(String sname);
	List<Student> getByMarks(Double marks);
	Student updateStudent(Student e);
	void deleteById(int sid);

}
