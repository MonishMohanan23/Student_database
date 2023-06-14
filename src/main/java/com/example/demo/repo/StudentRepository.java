package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query(value="select * from Student where sname=?1",nativeQuery = true)
	List<Student> findByName(String sname);
	@Query(value="select * from Student where marks>=?1",nativeQuery = true)
	List<Student> findByMarks(Double marks);


}
