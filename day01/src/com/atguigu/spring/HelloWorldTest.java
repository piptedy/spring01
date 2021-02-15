package com.atguigu.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {
    @Test
    public void test01(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        HelloWorld helloWorld = (HelloWorld) ioc.getBean("helloWorld");

        helloWorld.sayHello();
    }
}
