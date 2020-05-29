package com.example.demo.service.impl;

import com.example.demo.model.Profile;
import com.example.demo.model.SignInRequest;
import com.example.demo.model.SignUpRequest;
import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import com.example.demo.service.CloudService;
import com.example.demo.service.ProfileService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserService userService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private CloudService cloudService;

    @Override
    public User signUp(SignUpRequest signUpRequest) {
        boolean isUserExist = userService.isExistByEmail(signUpRequest.getEmail());
        if (isUserExist) {
            throw new IllegalStateException(String.format("User with such email %s already existed", signUpRequest.getEmail()));
        }
        Profile profile = new Profile();
        profile.setFirstName(signUpRequest.getFirstName());
        profile.setLastName(signUpRequest.getLastName());
        profile.setAge(signUpRequest.getAge());
        profile.setAvatarLink(cloudService.upload(signUpRequest.getAvatar()));
        Profile savedProfile = profileService.create(profile);

        User user = new User();
        user.setPassword(signUpRequest.getPassword());
        user.setEmail((signUpRequest.getEmail()));
        user.setProfile(savedProfile);
        return userService.create(user);
    }

    @Override
    public User signIn(SignInRequest signInRequest) {
        User user = userService.getByEmail(signInRequest.getEmail());
        if (user.getPassword().equals(signInRequest.getPassword())) {
            return user;
        }
        throw new IllegalStateException("Password is not correct");
    }

}
