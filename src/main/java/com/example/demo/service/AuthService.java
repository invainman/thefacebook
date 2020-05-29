package com.example.demo.service;

import com.example.demo.model.SignInRequest;
import com.example.demo.model.SignUpRequest;
import com.example.demo.model.User;

public interface AuthService {

    User signUp(SignUpRequest signUpRequest);

    User signIn(SignInRequest signInRequest);

}
