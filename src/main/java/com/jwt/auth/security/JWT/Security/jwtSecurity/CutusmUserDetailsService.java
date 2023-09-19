package com.jwt.auth.security.JWT.Security.jwtSecurity;

import com.jwt.auth.security.JWT.Security.entity.Student;
import com.jwt.auth.security.JWT.Security.repository.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CutusmUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepositories studentRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepositories.findByName(username);

        if(student == null) {
            throw new UsernameNotFoundException("User Not Found !!");
        }
        return new CustomUserDetails(student);
    }
}
