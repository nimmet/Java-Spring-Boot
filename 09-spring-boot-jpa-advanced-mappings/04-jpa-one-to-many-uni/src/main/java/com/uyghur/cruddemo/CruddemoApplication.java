package com.uyghur.cruddemo;

import com.uyghur.cruddemo.dao.AppDAO;
import com.uyghur.cruddemo.entity.Course;
import com.uyghur.cruddemo.entity.Instructor;
import com.uyghur.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);

//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO);

//			findCoursesByInstructor(appDAO);

//			findInstructorWithCoursesJoinFetch(appDAO);

//			updateInstructor(appDAO);

//			updateCourse(appDAO);

//			deleteInstructor(appDAO);

			deleteCourse(appDAO);

		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int id=10;
		System.out.println("Finding course id: "+id);
		appDAO.deleteCourseById(id);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int id=10;
		System.out.println("Finding course id: "+id);
		Course course = appDAO.findCourseById(id);
		System.out.println("Updating course id: "+id);

		course.setTitle("Django Web Development");
		appDAO.update(course);
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: "+id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Updating instructor id: "+id);
		instructor.setLastName("Nimmet");
		appDAO.update(instructor);
		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: "+id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("Instructor: "+instructor);
		System.out.println("the associated courses: "+instructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesByInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);
		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("Instructor: "+instructor);

		System.out.println("Finding courses for instructor id: "+theId);

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		instructor.setCourses(courses);

		System.out.println("the associated courses: "+instructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);
		Instructor instructor = appDAO.findInstructorById(theId);
		System.out.println("Instructor: "+instructor);
		System.out.println("the associated courses: "+instructor.getCourses());
		System.out.println("Done!");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor =
				new Instructor("Atilla","Uyghur", "atilla@uyghur.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("www.uyghur.com/youtube","Coding, Swimming");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Python Programming");
		Course tempCourse2 = new Course("Java Web Development");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving instructor: "+tempInstructor);
		System.out.println("The courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!");


	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 6;
		System.out.println("Deleting instructor detail id: "+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 5;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("InstructorDetail: "+instructorDetail);
		System.out.println("the associated instructor: "+instructorDetail.getInstructor());
		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: "+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");

	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructorDetail only: "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {


		Instructor tempInstructor =
				new Instructor("Atilla","Uyghur", "atilla@uyghur.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail("www.uyghur.com/youtube","Coding, Swimming");



//		Instructor tempInstructor =
//				new Instructor("Gul","Jappar", "gul@uyghur.com");
//
//		InstructorDetail tempInstructorDetail =
//				new InstructorDetail("www.uyghur.com/youtube","Piano, Cooking");
//

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: "+tempInstructor);

		appDAO.save(tempInstructor);
	}
}
