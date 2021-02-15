package com.atguigu.spring;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class BookShop {
    private List<Book> list;

    public BookShop() {
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public List<Book> getList() {
        return list;
    }
}
