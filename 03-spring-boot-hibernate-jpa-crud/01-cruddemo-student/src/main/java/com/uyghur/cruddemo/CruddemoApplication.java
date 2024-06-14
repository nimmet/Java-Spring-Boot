package com.uyghur.cruddemo;

import com.uyghur.cruddemo.dao.StudentDAO;
import com.uyghur.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
//			Student s = findStudent(studentDAO,2);
//			System.out.println("Student found: "+s);

//
//			readStudent(studentDAO);
//			queryForStudent(studentDAO);

//			queryForStudentByLastName(studentDAO);

//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);

//			deleteAllStudent(studentDAO);


		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int row = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+row);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 3;
		System.out.println("Deleting student id: "+id);
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student student = studentDAO.findById(studentId);
		System.out.println("Getting student with id: "+studentId);

		student.setFirstName("John");
		studentDAO.update(student);

		System.out.println("Updated student: "+student);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		for (Student s: studentDAO.findByLastName("Doe")){
			System.out.println(s);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for(Student s:students)
			System.out.println(s);
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object....");
		Student tempStudent = new Student("Daffy","Duck","duck@test.com");

		System.out.println("Saving the student ....");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();

		System.out.println("Saved student. Generated id: "+theId);

		System.out.println("Retrieving student with id: "+theId);
		Student  myStudent = studentDAO.findById(theId);

		System.out.println("Found the student: "+myStudent);
	}

	private Student findStudent(StudentDAO studentDAO,int id){
		return studentDAO.findById(id);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		List<Student> students = new ArrayList<>();

		System.out.println("Creating 3 student objects ....");
		students.add(new Student("John","Doe","john@test.com"));
		students.add(new Student("Mary","Public","mary@test.com"));
		students.add(new Student("Bonita","Applebum","bonita@test.com"));

		System.out.println("Saving the students ....");
		for(Student student : students){
			studentDAO.save(student);
		}



	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object....");
		Student tempStudent = new Student("Paul","Doe","paul@test.com");

		System.out.println("Saving the student ....");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}
}
