package br.dev.ferreiras.jpahibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.dev.ferreiras.jpahibernate.dao.StudentDAO;
import br.dev.ferreiras.jpahibernate.entity.Student;

@SpringBootApplication
public class JpahibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpahibernateApplication.class, args);
	}

	@Bean
//	public CommandLineRunner commandLineRunner(String[] args) {
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
//			System.out.println("Hello World!!!");
//			createStudent(studentDAO);		
//			readStudent(studentDAO);

			queryForStudents(studentDAO);

		};

	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> list = studentDAO.findAll();


		for (Student students : list) {
			System.out.println(students);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create the student object

		Student student = new Student("Ricardo", "Silva", "rnhc1000@gmail.com");
		// save the object

		studentDAO.save(student);

		// display id of the saved object

		System.out.println("\nId of the saved student: " + student.getId());

		// retrieve the id of the student, given its primary key
		Student myStudent = studentDAO.findById(student.getId());

		System.out.println("\nThese are the retrieved student data: " + myStudent);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object

		Student student = new Student("Ricardo", "Ferreira", "ricardo@ferreiras.dev.br");

		// save the object

		studentDAO.save(student);

		// display id of the saved object

		System.out.println("Id of the saved student: " + student.getId());

	}

};