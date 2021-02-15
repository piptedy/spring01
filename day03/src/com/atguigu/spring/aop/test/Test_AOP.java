package com.atguigu.spring.aop.test;

import com.atguigu.spring.aop.beans2.Caculator;
import com.atguigu.spring.beans.User;
import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.dao.UserDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
@ContextConfiguration(locations = "classpath:beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Test_AOP {
//    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

//    JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");
    @Autowired
    UserDao<User> userDao;
//    @Test
//    public void test01(){
//        Caculator caculator = (Caculator) ioc.getBean("caculator");
//        int add = caculator.add(10, 2);
//        System.out.println(add);
//        int div = caculator.div(10, 0);
//        System.out.println(div);
//    }
//    @Test
//    public void test02(){
//      String sql = "INSERT INTO `employee`(`last_name`,`email`,`salary`) VALUES(?,?,?)";
//      jdbcTemplate.update(sql,"雷军","ayok@xioami.com",8888);
//    }
//    @Test
//    public void test03(){
//        String sql = "INSERT INTO `employee`(`last_name`,`email`,`salary`) VALUES(?,?,?)";
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"李彦宏","lyh@baidu.com",6666});
//        list.add(new Object[]{"张一鸣","zym@marz.com",1});
//        jdbcTemplate.batchUpdate(sql,list);
//    }
    @Test
    public void test04(){

//        userDao.addUser(new User(null,"周鸿祎","zhy@360.com",0));
//        userDao.deleteUser("8");
//        userDao.updateUser(new User(7,"周鸿祎","zhy@360.com",0003));
//        User user = userDao.selectSingleById("4");
//        System.out.println(user);
//        List<User> userList = userDao.selectAll();
//        for (User user : userList) {
//            System.out.println(user);
//        }

    }
}
