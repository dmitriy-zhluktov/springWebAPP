package com.arc.model.service;

import com.arc.model.dao.User;

import java.util.List;

public interface UserService {
    User findByUserName(String username);
    List<User> getAllUsers(boolean withoutCurrent);
    User addUser(String name, String password, boolean enabled, String role);
    void deleteUser(int id);
}
