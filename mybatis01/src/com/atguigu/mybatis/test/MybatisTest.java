package com.atguigu.mybatis.test;

import com.atguigu.mybatis.entities.Department;
import com.atguigu.mybatis.entities.Employee;
import com.atguigu.mybatis.mapper.DepartmentMapper;
import com.atguigu.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test01() throws IOException {
        //设置MyBatis全局配置文件的路径
        String resource = "mybatis-config.xml";
        //读取类路径下的配置文件得到输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象，相当于Connection对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            //获取Mapper代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            //调用EmployeeMapper中获取一个对象的方法
//            Employee employeeById = mapper.getEmployeeById(1);
//            System.out.println(employeeById);
//            //调用add
//            mapper.addEmployee(new Employee(null,"盖亚","gaiya@m78.com",10000.00,6));
            //调用getALL
//            List<Employee> employees = mapper.selectAll();
//            for (Employee employee : employees) {
//                System.out.println(employee);
//            }
            //测试联合查询
//            Employee employee = mapper.getEmployeeAndDeptById(1);
//            System.out.println(employee);
            //测试分布查询
//            Employee employeeAndDeptById2 = mapper.getEmployeeAndDeptById2(1);
//            System.out.println(employeeAndDeptById2);

            //测试department的级联查询
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
//            Department departmentAndEmpsById = departmentMapper.getDepartmentAndEmpsById(6);
//            System.out.println(departmentAndEmpsById);
            //测试department的分步查询
            Department departmentAndEmpsByStep = departmentMapper.getDepartmentAndEmpsByStep(6);
            System.out.println(departmentAndEmpsByStep);


        } finally {
            //关闭sqlSession
            sqlSession.close();
        }

    }
}
