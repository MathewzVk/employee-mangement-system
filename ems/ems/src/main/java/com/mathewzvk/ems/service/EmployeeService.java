package com.mathewzvk.ems.service;

import com.mathewzvk.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee theEmployee);

}
