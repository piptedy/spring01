package com.atgui.spring.service;

import java.util.List;

public interface Cashier {
    //去结账，一次买多本图书
    void checkout(int userId, List<String> isbns);
}
