package com.mathewzvk.ems.service;

import com.mathewzvk.ems.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee theEmployee);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Employee theEmployee);

    void deleteEmployee(Employee theEmployee);

}
