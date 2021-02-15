package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entities.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    Employee getEmployeeById(Integer id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    List<Employee> selectAll();
    void deleteById(Integer id);
    Employee getEmployeeByIdAndName(@Param("id") Integer id, @Param("userName") String userName);
//    Employee getEmployeeByIdAndName( Integer id,String userName);
    Map<String, Object> getEmployeeReturnMap(Integer id);
    @MapKey("id")
    Map<String, Employee> getEmployeesReturnMap();
    Employee getEmployeeByEmailAndName(Map<String ,String> map);
}
