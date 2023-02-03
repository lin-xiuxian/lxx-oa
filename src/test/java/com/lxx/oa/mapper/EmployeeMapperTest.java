package com.lxx.oa.mapper;

import com.lxx.oa.entity.Employee;
import com.lxx.oa.utils.MybatisUtils;
import org.junit.Test;

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
}