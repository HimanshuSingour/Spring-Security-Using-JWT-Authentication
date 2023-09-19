package com.jwt.auth.security.JWT.Security.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT_TABLE")
@Component
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STD_ID")
    private Integer studentId;

    @Column(name = "STD_NAME")
    private String studentName;

    @Column(name = "STD_ROLE")
    private String studentRole;

    @Column(name = "STD_PASSWORD")
    private String studentPassword;


}
