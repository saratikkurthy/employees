package com.practice.employees.service;

import com.practice.employees.model.Employees;

import com.practice.employees.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;

    public List<Employees> listAllEmployees() {
        return employeesRepository.findAll();

    }

    public List<Employees> getByFirstName(String firstName) {
        return employeesRepository.findByFirstName(firstName);

    }

    public List<Employees> listByDeleted(int deleted) {
        return employeesRepository.findByDeleted(deleted);

    }

}
