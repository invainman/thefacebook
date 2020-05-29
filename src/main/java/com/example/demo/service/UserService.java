package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.dto.UserDto;

public interface UserService {

    User create(User user);

    void deleteById(Long id);

    User update(UserDto user);

    User getById(Long id) throws RuntimeException;

    boolean isExistByEmail(String email);

    User getByEmail(String email);

}
