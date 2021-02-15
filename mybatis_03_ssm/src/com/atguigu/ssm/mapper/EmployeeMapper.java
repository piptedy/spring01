package com.atguigu.ssm.mapper;

import com.atguigu.ssm.entities.Department;
import com.atguigu.ssm.entities.Employee;

import java.util.List;

public interface EmployeeMapper {
    Employee getEmployeeById(Integer id);
    List<Employee> getEmployees();
    List<Department> getDepartments();
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(Integer id);

}
