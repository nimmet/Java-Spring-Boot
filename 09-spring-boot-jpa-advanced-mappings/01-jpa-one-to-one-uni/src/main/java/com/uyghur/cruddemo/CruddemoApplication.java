package com.uyghur.cruddemo;

import com.uyghur.cruddemo.dao.AppDAO;
import com.uyghur.cruddemo.entity.Instructor;
import com.uyghur.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 3;
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
