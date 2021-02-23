package com.PComponents.service;

import com.PComponents.model.User;

public interface UserService {

    public User findUserByEmail(String email) ;
    public User saveUser(User user);
}
