package com.arc.model.dao.service;

import com.arc.model.dao.User;

import java.util.List;

public interface UserDao {
    User findByUserName(String username);
    List<User> getAllUsers(boolean withoutCurrent);
    User addUser(String name, String password, boolean enabled, String role);
}
