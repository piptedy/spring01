package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entities.Department;

public interface DepartmentMapper {
    Department getDepartmentById(Integer id);
    Department getDepartmentAndEmpsById(Integer id);
    Department getDepartmentAndEmpsByStep(Integer id);
}
