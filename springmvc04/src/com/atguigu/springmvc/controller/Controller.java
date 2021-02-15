package com.atguigu.springmvc.controller;

import com.atguigu.springmvc.entities.Department;
import com.atguigu.springmvc.entities.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
public class Controller {
    @ResponseBody
    @RequestMapping(value = "/dojson",method = RequestMethod.POST)
    public Employee dojson(){
        return new Employee(1, "zhangsan", "zhangsan@atguigu.com", 1, new Department(1001, "Teacher"));

    }
}
