package com.atguigu.springmvc.dao.impl;

import com.atguigu.springmvc.dao.BookDao;
import com.atguigu.springmvc.entities.Book;
import com.atguigu.springmvc.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Book> getAllBooks() {
//        private Integer id;
//        private String title; //书名
//        private String author; //作者
//        private double price; //价格
//        private Integer sales; //销量
//        private Integer stock; //库存
//        private String imgPath = "static/img/default.jpg"; //封面图片的路径
        String sql="select id,title,author,price,sales,stock,img_path imgPath from books";
        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<>(Book.class);
        List<Book> books = jdbcTemplate.query(sql, rowMapper);
        return books;
    }

    @Override
    public void saveBook(Book book) {
        String sql = "insert into books(title,author,price,sales,stock) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock());
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update books set title=?,author=?,price=?,sales=?,stock=? where id=?";
        jdbcTemplate.update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getId());
    }

    @Override
    public Book getBookById(Integer id) {
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from books where id=?";
        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<>(Book.class);
        Book book = null;
        try {
            book = jdbcTemplate.queryForObject(sql, rowMapper, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public void delBook(Integer id) {
        String sql="delete from books where id=?";
        jdbcTemplate.update(sql,id);
    }
}
