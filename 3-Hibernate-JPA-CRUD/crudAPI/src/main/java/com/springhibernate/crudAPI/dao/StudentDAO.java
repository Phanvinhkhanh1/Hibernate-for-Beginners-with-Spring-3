package com.springhibernate.crudAPI.dao;

import com.springhibernate.crudAPI.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findStudentById(int id);

    List<Student> findAll();
}
