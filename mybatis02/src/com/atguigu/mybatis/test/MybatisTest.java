package com.atguigu.mybatis.test;

import com.atguigu.mybatis.entities.Employee;
import com.atguigu.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MybatisTest {
    public SqlSessionFactory getsSlSessionFactory() throws IOException {
        //设置MyBatis全局配置文件的路径
        String resource = "mybatis-config.xml";
        //读取类路径下的配置文件得到输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
    @Test
    public void test01() throws IOException {
        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getsSlSessionFactory();
        //获取sqlSession对象，相当于connection对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            //获取mapper代理对象
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            Employee employee = mapper.getEmployeeByIdAndName(1, "HanZong");
//            System.out.println(employee);
            //测试getEmployeeReturnMap
//            Map<String, Object> employeeReturnMap = mapper.getEmployeeReturnMap(2);
            //            System.out.println(employeeReturnMap);
            // 测试getEmployeesReturnMap
//            Map<String, Employee> employeesReturnMap = mapper.getEmployeesReturnMap();
//            Set<Map.Entry<String, Employee>> entries = employeesReturnMap.entrySet();
//            for (Map.Entry<String, Employee> entry : entries) {
//                System.out.println(entry);
//            }
            //测试getEmployeeByEmailAndName
            Map<String,String> map = new HashMap<>();
            map.put("ln","Mayun");
            map.put("em","mayun@alibaba.com");

            Employee employee = mapper.getEmployeeByEmailAndName(map);
            System.out.println(employee);
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }
}
