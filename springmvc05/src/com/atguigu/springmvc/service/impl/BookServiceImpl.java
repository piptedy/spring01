package com.atguigu.springmvc.service.impl;

import com.atguigu.springmvc.dao.BookDao;
import com.atguigu.springmvc.entities.Book;
import com.atguigu.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDao.getBookById(id);
    }

    @Override
    public void delBook(Integer id) {
        bookDao.delBook(id);
    }

}
