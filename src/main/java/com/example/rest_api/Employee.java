package com.example.rest_api;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("employees")
public class Employee {

    @Id
    private Long employeeid;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String notes;
    // Constructors, getters, setters

    public Long getEmployeeid() {
        return employeeid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNotes() {
        return notes;
    }
}