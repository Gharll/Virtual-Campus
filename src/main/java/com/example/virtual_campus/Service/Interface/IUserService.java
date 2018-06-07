package com.example.virtual_campus.Service.Interface;

import com.example.virtual_campus.model.User;

public interface IUserService {

    User findUserByEmail(String email);
    void saveUser(User user);
}
