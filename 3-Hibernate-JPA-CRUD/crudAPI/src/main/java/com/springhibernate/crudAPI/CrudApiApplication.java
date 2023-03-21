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
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
            readStudent(studentDAO);
        };
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findStudentById(3);
        System.out.println(student.toString());
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Create new student ...");
        Student student1 = new Student("Phan Thi", "Phuong", "Phuong1992@gmail.com");
        Student student2 = new Student("Phan Vinh", "Tung", "Tung1993@gmail.com");
        Student student3 = new Student("Phan Vinh", "Khanh", "Khanh161297@gmail.com");

        System.out.println("Saving student into database");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

    }

    public void createStudent(StudentDAO studentDAO) {
        System.out.println("Create new student ...");
        Student student = new Student("Phan Vinh", "Khanh", "Khanh161297@gmail.com");

        System.out.println("Saving student " + student + " into database");
        studentDAO.save(student);

        System.out.println("Saved student with id = " + student.getId());
    }

}
