package com.uyghur.cruddemo.service;

import com.uyghur.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

     List<Employee> findAll();
     Employee findById(int theId);

     Employee save(Employee theEmployee);

     void deleteById(int theId);
}
