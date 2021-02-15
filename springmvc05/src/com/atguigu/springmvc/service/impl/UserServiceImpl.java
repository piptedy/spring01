package com.atguigu.springmvc.service.impl;

import com.atguigu.springmvc.dao.UserDao;
import com.atguigu.springmvc.dao.impl.UserDaoImpl;
import com.atguigu.springmvc.entities.User;
import com.atguigu.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUser(User user) {
        User user1 = userDao.getUser(user);
        return user1;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
