package com.uday.springjpa.CrudDemo;

import com.uday.springjpa.CrudDemo.dao.StudentDAO;
import com.uday.springjpa.CrudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {
			//createStudent(studentDAO);
			//queryForStudents(studentDao);
			//updateStudent(studentDao);
			createMultipleStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDao)
	{
	/*Student tempStudent =  new Student("John","Daly","johnD@tenl.com");
	studentDao.save(tempStudent);

	System.out.println("New Student Id created : "+tempStudent.getId());

	int id = tempStudent.getId();

		Student student = studentDao.findById(id);
		System.out.println(student.toString());*/



	}

	private void createMultipleStudents(StudentDAO studentDao)
	{
	Student tempStudent =  new Student("Mary","Daly","maryD@tenl.com");
	Student tempStudent1 =  new Student("Mary","Jane","maryJ@tenl.com");
	Student tempStudent2 =  new Student("Peter","Parker","peterP@tenl.com");


		studentDao.save(tempStudent);
		studentDao.save(tempStudent1);

		studentDao.save(tempStudent2);
		int id = tempStudent.getId();

		Student student = studentDao.findById(id);
		System.out.println(student.toString());



	}


			private void queryForStudents(StudentDAO studentDAO)
			{
				List<Student> students = studentDAO.findAll();

				for (Student tempStudent:students)
				{
					System.out.println(tempStudent);
				}

			}

			private void quertByLastName(StudentDAO studentDAO)
			{
				List<Student> students = studentDAO.findByLastName("Daly");
				for (Student tempStudent:students)
				{
					System.out.println(tempStudent);
				}
			}

			private void updateStudent(StudentDAO studentDAO)
			{
				int studentId=4;
				Student myStudent = studentDAO.findById(studentId);
				System.out.println("Before Update : "+myStudent);


				myStudent.setEmail("tj@tenl.com");
				studentDAO.update(myStudent);

				System.out.println("After Update : "+myStudent);

			}

}
