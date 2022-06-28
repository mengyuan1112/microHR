package com.example.demo.service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> get() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> checkEmployee(Employee employee) {
        return employeeRepository.findEmployeeByEmail(employee.getEmail());
    }
}
