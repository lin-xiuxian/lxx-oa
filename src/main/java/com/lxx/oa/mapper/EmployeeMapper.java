package com.lxx.oa.mapper;

import com.lxx.oa.entity.Employee;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public interface EmployeeMapper {
    public Employee selectById(Long employeeId);
}
