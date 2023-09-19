package com.jwt.auth.security.JWT.Security.service;

import com.jwt.auth.security.JWT.Security.entity.Student;
import com.jwt.auth.security.JWT.Security.repository.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepositories studentRepositories;


    @Override
    public Student saveStudentDetails(Student student) {
        return studentRepositories.save(student);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        Student student = studentRepositories.findById(studentId).orElseThrow();
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = studentRepositories.findAll();
        return students;
    }
}
