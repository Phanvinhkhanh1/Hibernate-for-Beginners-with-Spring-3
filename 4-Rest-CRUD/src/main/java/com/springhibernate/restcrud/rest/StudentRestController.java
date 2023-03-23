package com.springhibernate.restcrud.rest;

import com.springhibernate.restcrud.entity.Student;
import com.springhibernate.restcrud.error.StudentErrorResponse;
import com.springhibernate.restcrud.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        if ((studentId >= students.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Not found student with id = " + studentId);
        }
        return students.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        StudentErrorResponse errorResponse = new StudentErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
