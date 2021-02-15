package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.entites.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HelloWorld {
    @RequestMapping("/helloWorld")
    public String helloWorld(){
        return "success";
    }
    @RequestMapping("/pojo")
    public String pojo(Employee employee){
        System.out.println(employee);
        return "success";
    }
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加响应对象
        modelAndView.addObject("user","admin");
        //设置视图名
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("/testMap")
    public String testMap(Map<String,String> map){
        map.put("user","admin");
        return "success";

    }
}
