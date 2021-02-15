package com.atguigu.springmvc.dao.impl;

import com.atguigu.springmvc.dao.UserDao;
import com.atguigu.springmvc.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public User getUser(User user) {
        String sql = "SELECT id,`username`,`password`,`email` FROM users WHERE username=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

        User user1 = null;
        try {
            user1 = jdbcTemplate.queryForObject(sql, rowMapper, user.getUsername());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user1;
    }

    @Override
    public void saveUser(User user) {
        String sql = "insert into users(username,password,email) values(?,?,?)";


        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail());


    }
}
