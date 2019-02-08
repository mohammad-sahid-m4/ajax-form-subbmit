package com.metafour.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.metafour.model.Student;
import com.metafour.repo.StudentRepository;
import com.metafour.service.StudentService;
import com.metafour.response.*;

@RestController
@RequestMapping("api/customer")
public class RestWebController {

	@Autowired
	StudentService studentservice;
	@Autowired
	StudentRepository studentrepository;
	List<Student> stu = new ArrayList<>();

	@GetMapping(value = "/all")
	public Response getResource() {
		stu = studentservice.getAllStudentData();
		return new Response("Done", stu);
	}

	@PostMapping(value = "/save")
	public Response postCustomer(Student student) {
		studentrepository.save(student);
		return new Response("Done", student);
	}
}