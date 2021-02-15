package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entities.Employee;

import java.util.List;

public interface EmployeeMapper {
    Employee getEmployeeById(Integer id);
    Employee getEmployeeByDeptid(Integer id);

    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    List<Employee> selectAll();
    void deleteById(Integer id);
    Employee getEmployeeByIdAndName(Integer id,String userName);
    Employee getEmployeeAndDeptById(Integer id);
    Employee getEmployeeAndDeptById2(Integer id);
    Employee getEmployeeByConditionIf(Employee employee);
}
