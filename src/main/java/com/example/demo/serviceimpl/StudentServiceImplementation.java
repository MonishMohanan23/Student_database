package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFound;
import com.example.demo.module.Student;
import com.example.demo.repo.StudentRepository;
import com.example.demo.service.StudentService;
@Service
public class StudentServiceImplementation implements StudentService{
	@Autowired
	StudentRepository repo;

	@Override
	public Student addStudent(Student e) {
		// TODO Auto-generated method stub
		return repo.save(e);
	}

	@Override
	public Student getByID(Integer sid) {
		return repo.findById(sid).orElseThrow(()->new ResourceNotFound("Student", "Id", sid));
	}

	@Override
	public List<Student> getBySname(String sname) {

		return repo.findByName(sname);
	}

	@Override
	public List<Student> getByMarks(Double marks) {
		return repo.findByMarks(marks);
	}

	@Override
	public Student updateStudent(Student s) {
		Student s1=repo.findById(s.getSid()).orElse(null);
		if(s1!=null)
		{
			s1.setSname(s.getSname());
			s1.setBranch(s.getBranch());
			s1.setCollege_name(s.getCollege_name());
			s1.setMarks(s.getMarks());
			
			return repo.save(s1);
		}
		else
		{
			throw new ResourceNotFound("Student", "id", s.getSid());
		}
	}

	@Override
	public void deleteById(int sid) {
		
		repo.deleteById(sid);
		
	}


}
