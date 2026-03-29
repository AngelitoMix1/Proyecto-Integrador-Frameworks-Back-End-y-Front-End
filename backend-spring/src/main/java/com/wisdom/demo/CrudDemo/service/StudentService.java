package com.wisdom.demo.CrudDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisdom.demo.CrudDemo.model.Student;
import com.wisdom.demo.CrudDemo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student save(Student student) throws Exception{
		return studentRepository.save(student);
	}
	
	public List<Student> getStudent() throws Exception{
		return studentRepository.findAll();
	}
	public Student update(Student student) throws Exception{
		return studentRepository.save(student);
	}
	public void delete(int id) throws  Exception{
		studentRepository.deleteById(id);
	}
}

