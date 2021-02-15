package com.atgui.spring.service.impl;

import com.atgui.spring.service.BookShopService;
import com.atgui.spring.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cashier")
public class CashierImpl implements Cashier {
    @Autowired
    private BookShopService bookShopService;
    @Transactional
    @Override
    public void checkout(int userId, List<String> isbns) {
        for (String s : isbns) {
            bookShopService.purchase(userId,s);
        }
    }
}
