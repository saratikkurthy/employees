package com.practice.employees.repository;

import com.practice.employees.model.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentsRepository extends JpaRepository<Departments, String> {
    @Query("SELECT DEP FROM Departments DEP where DEP.deleted=0")
    List<Departments> findByDeleted();
}
