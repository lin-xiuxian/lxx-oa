package com.lxx.oa.service;

import com.lxx.oa.entity.Department;
import com.lxx.oa.mapper.DepartmentMapper;
import com.lxx.oa.utils.MybatisUtils;

/**
 * @author 林修贤
 * @date 2023/2/4
 * @description
 */
public class DepartmentService {
    public Department selectById(Long departmentId){
        Department d = (Department)MybatisUtils.executeQuery(sqlSession -> {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department department = mapper.selectById(departmentId);
            return department;
        });
        return d;
    }
}
