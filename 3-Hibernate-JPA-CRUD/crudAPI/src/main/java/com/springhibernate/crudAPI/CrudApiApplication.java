package com.springhibernate.crudAPI;

import com.springhibernate.crudAPI.dao.StudentDAO;
import com.springhibernate.crudAPI.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            retrieveAllStudents(studentDAO);
//            retrieveAllStudentsWithLastName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        int numRowsDeleted = studentDAO.deleteStudents();

        System.out.println("Number of row deleted = " + numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        studentDAO.deleteStudentById(3);
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findStudentById(1);
        System.out.println("Student with id = 1 is " + student.toString());
        System.out.println("Updating student ...");
        student.setEmail("Money@gmail.com");

        studentDAO.update(student);
        System.out.println("Student after update " + student.toString());
    }

    private void retrieveAllStudentsWithLastName(StudentDAO studentDAO) {
        String lastName = "Khanh";
        List<Student> students = studentDAO.findStudentsByLastName(lastName);

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    private void retrieveAllStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student student : students) {
            System.out.println(student.toString());
        }
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
