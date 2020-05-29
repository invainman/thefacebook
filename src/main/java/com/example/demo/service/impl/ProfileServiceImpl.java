package com.example.demo.service.impl;

import com.example.demo.model.Profile;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public Profile update(Profile profile) {
        return profileRepository.save(profile);
    }


    @Override
    public Profile getById(Long id) {
        return profileRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Profile not found"));
    }

    @Override
    public List<Profile> search(String name, Long ageTo, Long ageFrom) {
        List<Profile> profiles = profileRepository.findAll();
        return profiles.stream()
                .filter(profile -> profile.getAge() >= ageFrom && profile.getAge() <= ageTo && profile.getFirstName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

}
