package com.atguigu.ssm.controller;

import com.atguigu.ssm.entities.Department;
import com.atguigu.ssm.entities.Employee;
import com.atguigu.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping("/getEmps")
    public String getEmps(Map<String ,Object> map){
        List<Employee> employees = employeeService.getEmployees();
        map.put("emps",employees);
        return "list";
    }
    @RequestMapping("/addEmp")
    public String addEmp(Map<String ,Object> map){
        List<Department> departments = employeeService.getDepartments();
        map.put("depts",departments);
        map.put("command",new Employee());
        return "addEmp";
    }
    @RequestMapping(value = "/addEmp",method = RequestMethod.POST)
    public String addEmp(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/getEmps";
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String getOne(@PathVariable("id") Integer id,Map<String ,Object> map){
        Employee employeeById = employeeService.getEmployeeById(id);
        map.put("command",employeeById);
        List<Department> departments = employeeService.getDepartments();
        map.put("depts",departments);
        return "update";
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public String update(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/getEmps";
    }
    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return "redirect:/getEmps";
    }
}
