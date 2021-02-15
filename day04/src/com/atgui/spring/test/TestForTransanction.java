package com.atgui.spring.test;

import com.atgui.spring.dao.BookShopDao;
import com.atgui.spring.service.BookShopService;
import com.atgui.spring.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestForTransanction {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
    @Test
    public void test01(){
        BookShopDao bookShopDao = (BookShopDao) ioc.getBean("bookShopDao");
        Double bookPrice = bookShopDao.getBookPrice("1001");
        System.out.println(bookPrice);
        bookShopDao.updateBookStock("1001");
        bookShopDao.updateUserAccount(1,bookPrice);
    }
    @Test
    public void test02(){

        BookShopService bookShopService = (BookShopService) ioc.getBean("bookShopService");
        bookShopService.purchase(1,"1001");
    }
    @Test
    public void test03(){
        Cashier cashier = (Cashier) ioc.getBean("cashier");
        List<String> list = new ArrayList<>();
        list.add("1001");
        list.add("1002");
        cashier.checkout(1,list);
    }
}
