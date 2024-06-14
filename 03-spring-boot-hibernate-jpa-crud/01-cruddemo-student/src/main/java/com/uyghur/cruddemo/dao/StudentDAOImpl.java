package com.uyghur.cruddemo.dao;

import com.uyghur.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> students = entityManager.createQuery("From Student order by lastName",Student.class);
        return  students.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        TypedQuery<Student> query = entityManager.createQuery("From Student where lastName=:theData", Student.class);
        query.setParameter("theData",theLastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student s = entityManager.find(Student.class,id);

        entityManager.remove(s);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowDeleted = entityManager.createQuery("delete from Student").executeUpdate();
        return rowDeleted;
    }
}
