package com.atgui.spring.service;

import com.atgui.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Qualifier("userDao2")
    @Autowired
    UserDao userDao;
    @Override
    public void addUser() {
        userDao.addUser();
    }
}
