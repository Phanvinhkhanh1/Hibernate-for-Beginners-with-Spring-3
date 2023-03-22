package com.springhibernate.restcrud.rest;

import com.springhibernate.restcrud.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    @GetMapping("/info")
    private List<Student> getListStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Phan Thi", "Phuong"));
        students.add(new Student("Phan Vinh", "Tung"));
        students.add(new Student("Phan Vinh", "Khanh"));

        return students;
    }
}
