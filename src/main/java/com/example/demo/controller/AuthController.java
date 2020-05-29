package com.example.demo.controller;

import com.example.demo.model.SignInRequest;
import com.example.demo.model.SignUpRequest;
import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/signup")
    public User signUp(@RequestParam("age") Long age,
                       @RequestParam("avatar") MultipartFile avatar,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password,
                       @RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName) {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setAge(age);
        signUpRequest.setAvatar(avatar);
        signUpRequest.setEmail(email);
        signUpRequest.setPassword(password);
        signUpRequest.setFirstName(firstName);
        signUpRequest.setLastName(lastName);

        return authService.signUp(signUpRequest);
    }

    @PostMapping(value = "/signin")
    public User signIn(@RequestBody SignInRequest signInRequest) {
        return authService.signIn(signInRequest);
    }

}
