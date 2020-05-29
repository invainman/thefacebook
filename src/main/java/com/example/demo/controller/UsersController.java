package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        userService.deleteById(id);
    }

    @PutMapping
    public User update(@RequestBody UserDto user) {
        return userService.update(user);
    }

    @GetMapping
    public User getById(@RequestParam Long id) {
        return userService.getById(id);
    }

}
