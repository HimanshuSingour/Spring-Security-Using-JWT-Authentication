package com.jwt.auth.security.JWT.Security.service;

import com.jwt.auth.security.JWT.Security.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudentDetails(Student student);

    Student getStudentById(Integer studentId);

    List<Student> getAllStudent();
}
