package com.atgui.spring.dao;

import org.springframework.stereotype.Repository;

@Repository("userDao2")
public class UserDaoImpl2 implements UserDao {
    @Override
    public void addUser() {
        System.out.println("UserDaoImpl2 的addUser()被调用");
    }
}
