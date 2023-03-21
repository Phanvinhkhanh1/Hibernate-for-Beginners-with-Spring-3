package com.springhibernate.crudAPI.daoImpl;

import com.springhibernate.crudAPI.dao.StudentDAO;
import com.springhibernate.crudAPI.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.Style;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("SELECT s FROM Student s order by s.lastName", Student.class);
        return studentTypedQuery.getResultList();
    }

    @Override
    public List<Student> findStudentsByLastName(String lastName) {
        TypedQuery<Student> typedQuery = entityManager.createQuery("SELECT s FROM Student s where s.lastName=:theData", Student.class);
        typedQuery.setParameter("theData",lastName);

        return typedQuery.getResultList();
    }
}
