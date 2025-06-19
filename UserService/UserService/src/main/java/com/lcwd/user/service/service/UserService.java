package com.lcwd.user.service.service;

import com.lcwd.user.service.entities.User;

import java.util.List;

public interface UserService {

    //Create a new user
    User createUser(User user);
    //Get user by ID
    User getUser(String userId);
    //Update user
    User updateUser(String userId, User user);
    //Delete user
    void deleteUser(String userId);
    //Get all users
    List<User> getAllUsers();


}
