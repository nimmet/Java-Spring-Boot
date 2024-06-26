package com.uyghur.cruddemo.dao;

import com.uyghur.cruddemo.entity.Course;
import com.uyghur.cruddemo.entity.Instructor;
import com.uyghur.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {

        entityManager.persist(instructor);

    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor instructor = entityManager.find(Instructor.class,theId);
        List<Course> courses = instructor.getCourses();
        for (Course course:courses){
            course.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,theId);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);

    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data",Course.class);
        query.setParameter("data",id);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i join fetch i.courses " +
                        "join fetch i.instructorDetail where i.id=:data",
                Instructor.class);
        query.setParameter("data",id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {

        entityManager.merge(instructor);


    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {

        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "+
                        "join fetch c.reviews where c.id=:data", Course.class);
        query.setParameter("data",id);

        return query.getSingleResult();
    }
}
