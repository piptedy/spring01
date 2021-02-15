package com.atguigu.springmvc.service.impl;

import com.atguigu.springmvc.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    public EmployeeServiceImpl() {
        System.out.println("EmployeeServiceImpl对象被创建");
    }

    @Override
    public void addEmployee() {
        System.out.println("EmployeeService中的添加方法");
    }
}
