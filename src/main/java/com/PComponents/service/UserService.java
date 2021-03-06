package com.PComponents.service;

import com.PComponents.model.User;

import java.util.List;

public interface UserService {

    public User findUserByEmail(String email);

    public User saveUser(User user);

    List<User> findAllUsers();
}
