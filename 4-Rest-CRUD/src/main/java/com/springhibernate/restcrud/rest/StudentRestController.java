package com.springhibernate.restcrud.rest;

import com.springhibernate.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students = new ArrayList<>();

    @PostConstruct
    private void loadData() {
        students.add(new Student("Phan Thi", "Phuong"));
        students.add(new Student("Phan Vinh", "Tung"));
        students.add(new Student("Phan Vinh", "Khanh"));
    }

    @GetMapping("/students/info")
    private List<Student> getListStudents() {
        return this.students;
    }

    @GetMapping("/students/{studentId}")
    private Student getStudentById(@PathVariable int studentId) {
        return students.get(studentId);
    }
}
