package com.atguigu.ssm.service;

import com.atguigu.ssm.entities.Department;
import com.atguigu.ssm.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(Integer id);
    List<Employee> getEmployees();
    List<Department> getDepartments();
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Integer id);
}
