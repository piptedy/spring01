package com.atguigu.springmvc.service;

import com.atguigu.springmvc.entities.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public void saveBook(Book book);
    public void updateBook(Book book);
    public Book getBookById(Integer id);
    public void delBook(Integer id);
}
