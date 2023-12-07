package com.mathewzvk.ems.service;

import com.mathewzvk.ems.entity.Employee;
import com.mathewzvk.ems.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee addEmployee(Employee theEmployee) {
        return repository.save(theEmployee);
    }
}
