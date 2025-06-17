package com.example.rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

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
    public Employee getEmployee(@PathVariable String id) {
        return employeeRepository.findById(Long.parseLong(id)) // Attempt to find the item by ID
                .orElseThrow(() -> new ResponseStatusException( // If not found...
                        HttpStatus.NOT_FOUND, // Throw ResponseStatusException with 404 status
                        "Employee with ID " + id + " not found" // Include a descriptive message
                ));
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
