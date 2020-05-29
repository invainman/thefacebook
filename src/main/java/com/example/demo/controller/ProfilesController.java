package com.example.demo.controller;

import com.example.demo.model.Profile;
import com.example.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profiles")
public class ProfilesController {

    @Autowired
    private ProfileService profileService;

    @PutMapping
    public Profile update(@RequestBody Profile profile) {
        return profileService.update(profile);
    }

    @GetMapping
    public Profile getById(@RequestParam Long id) {
        return profileService.getById(id);
    }

    @GetMapping (value = "/search")
    public List<Profile> search(@RequestParam String name, @RequestParam Long ageTo, @RequestParam Long ageFrom) {
        return profileService.search(name, ageTo, ageFrom);
    }
}
