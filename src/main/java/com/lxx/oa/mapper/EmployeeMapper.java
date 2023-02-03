package com.lxx.oa.mapper;

import com.lxx.oa.entity.Employee;

import java.util.List;
import java.util.Map;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public interface EmployeeMapper {
    public Employee selectById(Long employeeId);
    public List<Employee> selectByParams(Map params);
}
