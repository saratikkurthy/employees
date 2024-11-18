package com.practice.employees.repository;

import java.util.List;

import com.practice.employees.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
    @Query("SELECT EMP FROM Employees EMP WHERE EMP.firstName = :firstName")
    List<Employees> findByFirstName(@Param("firstName") String firstName);

    @Query("SELECT EMP FROM Employees EMP WHERE EMP.deleted = :deleted")
    List<Employees> findByDeleted(@Param("deleted") int deleted);

}