package com.jwt.auth.security.JWT.Security.controller;

import com.jwt.auth.security.JWT.Security.JwtStudentimpl.JwtMethodsHelper;
import com.jwt.auth.security.JWT.Security.entity.JwtRequest;
import com.jwt.auth.security.JWT.Security.entity.JwtResponse;
import com.jwt.auth.security.JWT.Security.entity.Student;
import com.jwt.auth.security.JWT.Security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/student/v1/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtMethodsHelper helper;


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

        this.doAuthenticate(request.getUserName(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .userName(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }


    @PostMapping("/save")
    ResponseEntity<Student> saveUser(@RequestBody Student student){
        Student student1 = studentService.saveStudentDetails(student);
        return new ResponseEntity<Student>(student1 , HttpStatus.ACCEPTED);

    }

    @GetMapping("/get/{studentId}")
    ResponseEntity<Student> getUserById(@PathVariable Integer studentId){
        Student student1 = studentService.getStudentById(studentId);
        return new ResponseEntity<Student>(student1 , HttpStatus.ACCEPTED);

    }

    @GetMapping("/get/current/user")
    public String getCurrentUser(Principal principal){
        return principal.getName();

    }

    @GetMapping("/getAll")
    ResponseEntity<List<Student>> getAllUsers(){
        List<Student> student1 = studentService.getAllStudent();
        return new ResponseEntity<List<Student>>(student1 , HttpStatus.ACCEPTED);

    }
}
