package com.practice.employees.service;

import com.practice.employees.model.Departments;
import com.practice.employees.repository.DepartmentsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DepartmentsService {
    @Autowired
    DepartmentsRepository departmentsRepository;

    public List<Departments> findAllDepartments() {
        List<Departments> findDepartments = departmentsRepository.findByDeleted();
        return findDepartments;
    }
}
