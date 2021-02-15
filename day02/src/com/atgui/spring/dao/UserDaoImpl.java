package com.atgui.spring.dao;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("UserDaoImp 的addUser()被调用");
    }
}
