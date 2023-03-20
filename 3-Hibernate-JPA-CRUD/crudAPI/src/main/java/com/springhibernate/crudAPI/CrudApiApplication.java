package com.springhibernate.crudAPI;

import com.springhibernate.crudAPI.dao.StudentDAO;
import com.springhibernate.crudAPI.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        };
    }

    public void createStudent(StudentDAO studentDAO) {
        System.out.println("Create new student ...");
        Student student = new Student("Phan Vinh", "Khanh", "Khanh161297@gmail.com");

        System.out.println("Saving student " + student + " into database");
        studentDAO.save(student);

        System.out.println("Saved student with id = " + student.getId());
    }

}
