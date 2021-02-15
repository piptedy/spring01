package com.atgui.spring.dao.impl;

import com.atgui.spring.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Double getBookPrice(String isbn) {
        String sql = "select price from book where isbn= ?";
        Double price = jdbcTemplate.queryForObject(sql, Double.class, isbn);
        return price;
    }

    @Override
    public void updateBookStock(String isbn) {
        String sql = "update book set stock = stock-1 where isbn=?";
        jdbcTemplate.update(sql,isbn);
    }

    @Override
    public void updateUserAccount(int userId, Double bookPrice) {
        String sql = "update account set balance=balance-? where id=?";
        jdbcTemplate.update(sql,bookPrice,userId);
    }
}
