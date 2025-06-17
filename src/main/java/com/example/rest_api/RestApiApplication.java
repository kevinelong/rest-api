package com.example.rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class RestApiApplication {
    @Autowired //initialized by the framework
    private EmployeeRepository employeeRepository;

    @RequestMapping("/employee")
    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll(); // Provided by CrudRepository
    }

    @RequestMapping(path = "/employee/{id}", method = RequestMethod.GET)
    public Optional<Employee> getEmployee(@PathVariable String id) {
        return employeeRepository.findById(Long.parseLong(id)); // Provided by CrudRepository
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(path = "/employee", method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
//
//    @RequestMapping(path = "/employee", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public String submitForm(@RequestParam String first, @RequestParam String last, @RequestParam String notes) {
//        Employee employee = new Employee(first, last, notes);
//        employeeRepository.save(employee);
//        return "success";
//    }

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
    }
}
