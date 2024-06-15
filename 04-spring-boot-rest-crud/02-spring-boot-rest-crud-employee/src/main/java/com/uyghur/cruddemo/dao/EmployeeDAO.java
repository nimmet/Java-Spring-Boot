package com.uyghur.cruddemo.dao;

import com.uyghur.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
