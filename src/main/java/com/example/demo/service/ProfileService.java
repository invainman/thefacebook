package com.example.demo.service;

import com.example.demo.model.Profile;

import java.util.List;

public interface ProfileService {

    Profile create(Profile profile);

    void deleteById(Long id);

    Profile update(Profile profile);

    Profile getById(Long id) throws RuntimeException;

    List<Profile> search(String name, Long ageTo, Long ageFrom) throws RuntimeException;
}
