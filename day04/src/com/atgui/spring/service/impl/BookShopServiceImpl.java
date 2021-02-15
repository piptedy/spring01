package com.atgui.spring.service.impl;

import com.atgui.spring.dao.BookShopDao;
import com.atgui.spring.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookShopDao bookShopDao;

    @Transactional(propagation = REQUIRES_NEW ,isolation = Isolation.REPEATABLE_READ)
    @Override
    public void purchase(int userId, String isbn) {
        Double bookPrice = bookShopDao.getBookPrice(isbn);
        System.out.println("第一次查询："+bookPrice);
        Double bookPrice2 = bookShopDao.getBookPrice(isbn);
        System.out.println("第二次查询："+bookPrice2);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateUserAccount(userId,bookPrice);
    }
}
