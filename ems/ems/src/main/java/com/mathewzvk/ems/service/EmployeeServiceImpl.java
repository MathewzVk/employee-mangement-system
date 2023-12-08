package com.mathewzvk.ems.service;

import com.mathewzvk.ems.entity.Employee;
import com.mathewzvk.ems.exception.ResourceNotFoundException;
import com.mathewzvk.ems.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Exists with ID: " + id));
    }

    @Override
    public Employee updateEmployee(Employee theEmployee) {
        return repository.save(theEmployee);
    }

    @Override
    public void deleteEmployee(Employee theEmployee) {
        repository.delete(theEmployee);
    }
}
