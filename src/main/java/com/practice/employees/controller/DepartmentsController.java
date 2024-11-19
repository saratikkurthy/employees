package com.practice.employees.controller;

import com.practice.employees.model.Departments;
import com.practice.employees.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    @Autowired
    DepartmentsService departmentsService;
    @GetMapping("")
    public List<Departments> getAllDepartments(){
        return departmentsService.findAllDepartments();
    }
}
