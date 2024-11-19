package com.practice.employees.controller;

import com.practice.employees.model.Employees;
import com.practice.employees.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeesController {
    @GetMapping("/employees")
    public String getEmployees() {
        return "Hello Employees";
    }

    @Autowired
    EmployeesService employeesService;

    @GetMapping("")
    public List<Employees> getAll() {
        return employeesService.listAllEmployees();
    }

    @GetMapping("/findByFirstName/{firstName}")
    public ResponseEntity<List<Employees>> getByFirstName(@PathVariable("firstName") String firstName) {
        try {
            List<Employees> findByFirstName = employeesService.getByFirstName(firstName);
            return new ResponseEntity<List<Employees>>(findByFirstName, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Employees>>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/findByLastName/{lastName}")
    public ResponseEntity<List<Employees>> getByLasttName(@PathVariable("lastName") String lastName) {
        try {
            List<Employees> findByFirstName = employeesService.getByLastName(lastName);
            return new ResponseEntity<List<Employees>>(findByFirstName, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Employees>>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/findActive")
    public ResponseEntity<List<Employees>> getByFirstName() {
        try {
            List<Employees> findByDeleted = employeesService.listByDeleted(0);
            return new ResponseEntity<List<Employees>>(findByDeleted, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Employees>>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
