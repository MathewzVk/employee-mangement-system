package com.mathewzvk.ems.controller;


import com.mathewzvk.ems.entity.Employee;
import com.mathewzvk.ems.repo.EmployeeRepository;
import com.mathewzvk.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService theService;


    @GetMapping
    public List<Employee> listEmployees(){
        return theService.getAllEmployees();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee theEmployee){
        return theService.addEmployee(theEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getSingleEmployee(@PathVariable Long id){
        Employee employee = theService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee theEmployee) {
        Employee employee = theService.getEmployeeById(id);
        employee.setFirstName(theEmployee.getFirstName());
        employee.setLastName(theEmployee.getLastName());
        employee.setEmail(theEmployee.getEmail());
        return ResponseEntity.ok(theService.updateEmployee(employee));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Employee employee = theService.getEmployeeById(id);
        theService.deleteEmployee(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
