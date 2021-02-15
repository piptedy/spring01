package com.atguigu.springmvc.dao;

import com.atguigu.springmvc.entities.User;

public interface UserDao {
    //查询单个用户
    public User getUser(User user);
    //存储单个用户
    public void saveUser(User user);
}
