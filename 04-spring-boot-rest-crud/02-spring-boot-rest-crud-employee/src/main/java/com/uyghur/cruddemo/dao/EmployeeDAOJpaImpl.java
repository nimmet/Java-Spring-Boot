package com.uyghur.cruddemo.dao;

import com.uyghur.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> emp = entityManager.createQuery("From Employee", Employee.class);

        return emp.getResultList();
    }

    @Override
    public Employee findById(int theId) {

        Employee theEmployee = entityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee emp = entityManager.merge(theEmployee);
        return emp;
    }

    @Override
    public void deleteById(int theId) {
        Employee emp = entityManager.find(Employee.class, theId);
        entityManager.remove(emp);
    }
}
