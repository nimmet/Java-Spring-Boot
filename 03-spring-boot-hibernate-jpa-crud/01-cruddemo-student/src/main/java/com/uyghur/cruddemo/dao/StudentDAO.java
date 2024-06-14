package com.uyghur.cruddemo.dao;

import com.uyghur.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);
    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
