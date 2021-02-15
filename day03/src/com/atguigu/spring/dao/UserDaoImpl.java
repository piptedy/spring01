package com.atguigu.spring.dao;

import com.atguigu.spring.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("userDao")
public class UserDaoImpl implements UserDao<User> {
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

//        JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO `employee`(`last_name`,`email`,`salary`) VALUES(?,?,?)";
        jdbcTemplate.update(sql,user.getName(),user.getEmail(),user.getSalary());

    }

    @Override
    public void deleteUser(String id) {
        String sql = "DELETE FROM employee WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE employee SET `last_name`=?,`email`=?,`salary`=? WHERE id=?";
        jdbcTemplate.update(sql,user.getName(),user.getEmail(),user.getSalary(),user.getId());
    }

    @Override
    public User selectSingleById(String id) {
        String sql="SELECT `id`,`last_name` name,`email`,`salary` FROM employee WHERE id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return user;
    }

    @Override
    public List<User> selectAll() {
        String sql="SELECT `id`,`last_name` name,`email`,`salary` FROM employee";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> userList = jdbcTemplate.query(sql, rowMapper);
        return userList;
    }
}
