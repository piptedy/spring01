package com.atguigu.springmvc.crud.controller;

import com.atguigu.springmvc.crud.dao.DepartmentDao;
import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Department;
import com.atguigu.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class GetAll {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public String getAll(Map<String,Object> map){
        Collection<Employee> employees = employeeDao.getAll();
        map.put("emps",employees);
        return "list";
    }
    @RequestMapping(value = "/addEmployee",method = RequestMethod.GET)
    public String goToAdd(Map<String,Object> map){
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts",departments);
        map.put("command",new Employee());
        return "add";
    }
    @RequestMapping(value = "/addEmployee",method = RequestMethod.POST)
    public String add(Employee employee){
        employeeDao.save(employee);
        return "redirect:/getAll";
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        System.out.println("post请求成功");
        return "redirect:/getAll";
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String getOne(@PathVariable("id") Integer id,Map<String,Object> map){
        Employee employee = employeeDao.get(id);
        map.put("command",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        map.put("depts",departments);
        return "update";
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/getAll";
    }
}
