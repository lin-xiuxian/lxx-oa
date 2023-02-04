package com.lxx.oa.mapper;

import com.lxx.oa.entity.Department;

/**
 * @author 林修贤
 * @date 2023/2/4
 * @description
 */
public interface DepartmentMapper {
    public Department selectById(Long departmentId);
}
