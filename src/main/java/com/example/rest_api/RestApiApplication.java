package com.example.rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SpringBootApplication
@RestController
@RequestMapping("/data")

public class RestApiApplication {
	@Autowired
	private EmployeeRepository employeeRepository;

	@RequestMapping("/employee")
	public Iterable<Employee> findAllEmployees() {
		return employeeRepository.findAll(); // Provided by CrudRepository
	}

	@GetMapping
	public ResponseEntity<String> getAll() {
		return new ResponseEntity<>("List of all data", HttpStatus.OK);
	}	@GetMapping

	@RequestMapping("/data2")
	public ResponseEntity<String> getAll2() {
		return new ResponseEntity<>("Second url baby", HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
