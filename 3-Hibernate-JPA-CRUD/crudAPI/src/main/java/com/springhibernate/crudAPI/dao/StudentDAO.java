package com.springhibernate.crudAPI.dao;

import com.springhibernate.crudAPI.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findStudentById(int id);
}
