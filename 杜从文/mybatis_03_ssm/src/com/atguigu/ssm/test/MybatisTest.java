package com.atguigu.ssm.test;

import com.atguigu.ssm.controller.EmployeeController;
import com.atguigu.ssm.mapper.EmployeeMapper;
import com.atguigu.ssm.service.EmployeeService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
@ContextConfiguration({"classpath:beans.xml","classpath:springmvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MybatisTest {
    @Autowired
    private EmployeeService employeeService;

   @Test
   public void test01(){
       System.out.println(employeeService);
   }

}
