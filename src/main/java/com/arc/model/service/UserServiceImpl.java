package com.arc.model.service;

import com.arc.model.dao.User;
import com.arc.model.dao.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public List<User> getAllUsers(boolean withoutCurrent) {
        return userDao.getAllUsers(withoutCurrent);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public User addUser(String name, String password, boolean enabled, String role) {
        return userDao.addUser(name, password, enabled, role);
    }

    @Override
    public void deleteUser(int id) {

    }
}
