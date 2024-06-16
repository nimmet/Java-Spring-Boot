package com.uyghur.cruddemo.rest;


import com.uyghur.cruddemo.entity.Employee;
import com.uyghur.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Employee findAll(@PathVariable int empId){

        Employee employee = employeeService.findById(empId);
        if (employee == null){
            throw new RuntimeException("Employee id not found - "+empId);
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{empId}")
    public String deleteEmployee(@PathVariable int empId){
        Employee emp = employeeService.findById(empId);
        if(emp == null){
            throw new RuntimeException("Employee id not found - "+empId);
        }
        employeeService.deleteById(empId);
        return "Deleted employee id - "+empId;
    }

}
