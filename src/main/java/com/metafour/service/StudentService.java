package com.metafour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metafour.model.Student;
import com.metafour.repo.StudentRepository;



@Service
public class StudentService {
	
	@Autowired StudentRepository studentRepository;
	
	public Student saveStudentData(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudentData(){
		return (List<Student>) studentRepository.findAll();
	}
	
	public Student findOne(Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public Student update(Student student) {
		return saveStudentData(student);
	}
	
	public long deleteOne(Long id) {
		Long i=id;
		studentRepository.deleteById(id);
		return i;
	}


}