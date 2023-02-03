package com.lxx.oa.service;

import com.lxx.oa.entity.Employee;
import com.lxx.oa.mapper.EmployeeMapper;
import com.lxx.oa.utils.MybatisUtils;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public class EmployeeService {
    public Employee selectById(Long employeeId){
        Employee employee = (Employee)MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            return mapper.selectById(employeeId);
        });
        return employee;
    }
}
