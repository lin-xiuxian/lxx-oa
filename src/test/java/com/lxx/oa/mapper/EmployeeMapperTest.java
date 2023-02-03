package com.lxx.oa.mapper;

import com.lxx.oa.entity.Employee;
import com.lxx.oa.utils.MybatisUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public class EmployeeMapperTest {

    @Test
    public void selectById() {
        MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.selectById(4l);
            System.out.println(employee);
            return employee;
        });
    }

    @Test
    public void selectByParams1() {
        Map params = new HashMap<>();
        params.put("level", 7);
        params.put("departmentId", 2);
        MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = employeeMapper.selectByParams(params);
            System.out.println(employees);
            return employees;
        });
    }

    @Test
    public void selectByParams2() {
        Map params = new HashMap<>();
        params.put("level", 8);
        MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = employeeMapper.selectByParams(params);
            System.out.println(employees);
            return employees;
        });
    }
}