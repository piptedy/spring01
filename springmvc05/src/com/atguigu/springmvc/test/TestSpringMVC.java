package com.atguigu.springmvc.test;

import com.atguigu.springmvc.dao.BookDao;
import com.atguigu.springmvc.dao.UserDao;
import com.atguigu.springmvc.entities.Book;
import com.atguigu.springmvc.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@ContextConfiguration(locations = "classpath:beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpringMVC {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserDao userDao;
    @Autowired
    BookDao bookDao;
    @Test
    public void test() throws SQLException {
        Connection connection = jdbcTemplate.getDataSource().getConnection();

        System.out.println(connection);
        System.out.println(jdbcTemplate);
    }
    @Test
    public void test02(){
        User cxk = userDao.getUser(new User(null, "cxk", "123", null));
        System.out.println(cxk);
    }
    @Test
    public void test03(){
        List<Book> list = bookDao.getAllBooks();
        for (Book book : list) {
            System.out.println(book);
        }
    }
}
