package com.mathewzvk.ems.controller;


import com.mathewzvk.ems.entity.Employee;
import com.mathewzvk.ems.repo.EmployeeRepository;
import com.mathewzvk.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService theService;

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> listEmployees(){
        return theService.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee theEmployee){
        return repository.save(theEmployee);
    }

}
