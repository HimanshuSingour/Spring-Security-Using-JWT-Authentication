package com.jwt.auth.security.JWT.Security.repository;

import com.jwt.auth.security.JWT.Security.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositories extends JpaRepository<Student , Integer> {

    @Query("SELECT s FROM Student s WHERE s.studentName = :studentName")
    Student findByName(@Param("studentName") String studentName);

}
