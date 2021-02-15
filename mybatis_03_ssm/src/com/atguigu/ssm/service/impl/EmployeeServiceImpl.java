package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.entities.Department;
import com.atguigu.ssm.entities.Employee;
import com.atguigu.ssm.mapper.EmployeeMapper;
import com.atguigu.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeMapper.getEmployeeById(id);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeMapper.getEmployees();
        return employees;
    }

    @Override
    public List<Department> getDepartments() {
        return employeeMapper.getDepartments();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeMapper.deleteEmployee(id);
    }
}
