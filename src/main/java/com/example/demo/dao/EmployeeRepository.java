package com.example.demo.dao;

import java.util.*;
import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//    @Query(value = "Select email From Employee Where Employee.email = ?1", nativeQuery = true)
    public Optional<Employee> findEmployeeByEmail(String email);
}
