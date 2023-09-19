package com.jwt.auth.security.JWT.Security.jwtSecurity;

import com.jwt.auth.security.JWT.Security.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class CustomUserDetails implements UserDetails {

    private Student student;

    public CustomUserDetails(Student student) {
        super();
        this.student = student;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(student.getStudentRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return student.getStudentPassword();
    }

    @Override
    public String getUsername() {
        return student.getStudentName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
