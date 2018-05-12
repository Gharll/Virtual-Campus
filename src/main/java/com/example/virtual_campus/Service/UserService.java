package com.example.virtual_campus.Service;

import com.example.virtual_campus.model.User;

public interface UserService {

    User findUserByEmail(String email);
    void saveUser(User user);
}
