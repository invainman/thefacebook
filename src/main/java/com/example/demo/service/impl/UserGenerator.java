package com.example.demo.service.impl;

import com.example.demo.model.SignInRequest;
import com.example.demo.model.SignUpRequest;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.UUID;

@Component
public class UserGenerator {
    @Autowired
    private AuthService authService;

    @Transactional
    @Scheduled(cron = "* */1 * * * *")
    public void generate() {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setAge(18 + (long) (Math.random() * 50));
        signUpRequest.setAvatar(null);
        signUpRequest.setEmail(UUID.randomUUID()+"@mail.ru");
        signUpRequest.setPassword(UUID.randomUUID().toString());
        signUpRequest.setFirstName("Generated");
        signUpRequest.setLastName("User");
        authService.signUp(signUpRequest);
    }
}
