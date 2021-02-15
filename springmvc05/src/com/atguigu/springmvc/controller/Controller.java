package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.entities.Book;
import com.atguigu.springmvc.entities.User;
import com.atguigu.springmvc.service.BookService;
import com.atguigu.springmvc.service.UserService;
import com.atguigu.springmvc.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    public Controller() {
        System.out.println("Controller的对象被创建");
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, Map<String,Object> map, HttpSession session){
        User user1 = userService.getUser(user);
        if(user1==null){
            map.put("msg","用户不存在，请重新输入");
            return "forward:/pages/user/login.jsp";
        }else {
            session.setAttribute("user",user);
            return "redirect:/pages/user/login_success.jsp";
        }

    }
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public String regist(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User(null,username,password,email);
        User user1 = userService.getUser(user);
        if (user1 != null) {
            map.put("msg","该用户名已存在,请重新输入");
            return "forward:/pages/user/regist.jsp";
        }else {
            userService.saveUser(user);
            return "redirect:/pages/user/regist_success.jsp";
        }

    }
    //处理ajax请求，用户名是否已存在
    @RequestMapping(value = "/checkUsername",method = RequestMethod.POST)
    public void checkUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        User user = userService.getUser(new User(null,username,null,null));
        if (user==null){
            response.getWriter().write("true");
        }else {
            response.getWriter().write("false");
        }
    }
    @RequestMapping(value = "/getAllBooks",method = RequestMethod.GET)
    public String getAllBooks(Map<String,Object> map){
        List<Book> list = bookService.getAllBooks();
        map.put("list",list);
        return "forward:/pages/manager/book_manager.jsp";
    }
    @RequestMapping(value = "/saveOrUpdateBook",method = RequestMethod.POST)
    public String saveOrUpdateBook(Book book){
        if(book.getId()==null||"".equals(book.getId())){
            bookService.saveBook(book);
        }else {
            bookService.updateBook(book);
        }
        return "redirect:/getAllBooks";
    }
    @RequestMapping(value = "/getBookById/{id}",method = RequestMethod.GET)
    public String getBookById(@PathVariable("id") Integer id,Map<String,Object> map){
        Book book = bookService.getBookById(id);
        map.put("book",book);
        return "forward:/pages/manager/book_edit.jsp";
    }
    @RequestMapping(value = "/delBook/{id}",method = RequestMethod.GET)
    public String delBook(@PathVariable("id") Integer id){
        bookService.delBook(id);
        return "redirect:/getAllBooks";
    }

}
