package com.arc.model.dao.service;

import com.arc.model.dao.User;

public interface UserDao {
    User findByUserName(String username);
}
