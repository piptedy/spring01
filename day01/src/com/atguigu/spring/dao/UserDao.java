package com.atguigu.spring.dao;

import java.util.List;

public interface UserDao<T> {
    public void addUser(T t);
    public void deleteUser(T t);
    public void updateUser(T t);
    public T selectSingleById(String id);
    public List<T> selectAll();

}
