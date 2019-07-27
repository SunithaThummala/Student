package com.example.student.dal;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.student.dal.entities.Student;
import com.example.student.dal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void testCreateStudent() {
		
		Student student = new Student();
		student.setName("suni");
		student.setFee(8.0);
		student.setCourse("jpa");
		studentRepository.save(student);
		
	}
	
	@Test
	public void testFindStudentById() {
		Optional<Student> student = studentRepository.findById((long) 1);
		System.out.print(student.get().toString());
	}
	
	@Test
	public void testUpdateStudent() {
		Optional<Student> student = studentRepository.findById((long) 1);
		student.get().setFee(40.0);
		studentRepository.save(student.get());
	}
	
	@Test
	public void testDeleteStudent() {
		Optional<Student> student = studentRepository.findById((long) 1);
		student.get().setFee(40.0);
		studentRepository.deleteById(1L);
	}


}
