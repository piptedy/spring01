package com.atguigu.spring;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class BookTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
    @Test
    public void test01(){

        Book book = (Book) ioc.getBean("book");
        System.out.println(book);
    }
    @Test
    public void test02(){
        CartItem cartItem1 = (CartItem) ioc.getBean("cartItem1");
        System.out.println(cartItem1);

    }
   @Test
   public void test03(){
//       BookShop listBean = (BookShop) ioc.getBean("list");
//       List<Book> list = listBean.getList();
//       for (Book book : list) {
//           System.out.println(book);
//       }
       List<Book> listBean = (List<Book>) ioc.getBean("listBean");
       for (Book book : listBean) {
           System.out.println(book);
       }
   }
   @Test
   public void test04() throws SQLException {
       DruidDataSource dataSource = (DruidDataSource) ioc.getBean("dataSource");
      DruidPooledConnection connection = dataSource.getConnection();
       System.out.println(connection);

   }
}
