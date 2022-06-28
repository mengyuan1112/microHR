package com.example.demo.controller;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/employee")
public class UserController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(value = "/register")
    public boolean register(@RequestBody Employee employee){
        if(employeeRepository.findEmployeeByEmail(employee.getEmail()).isPresent()) {
            return false;
        }
        employeeRepository.save(employee);
        return true;
    }

    @PostMapping(value = "/login")
    public boolean login(@RequestBody Employee employee){
        Optional<Employee> emp = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if(emp.isPresent() && emp.get().getPassword().equals(employee.getPassword())) {
            return true;
        }
        return false;
    }

    @PostMapping(value = "/{name}/info")
    public void modify(@RequestBody Employee employee) {

    }



    @GetMapping
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }
}
