package com.lxx.oa.service;

import com.lxx.oa.entity.Employee;
import com.lxx.oa.mapper.EmployeeMapper;
import com.lxx.oa.utils.MybatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description 获取当前员工的信息，姓名 岗位 职务等级 上级领导
 */
public class EmployeeService {
    public Employee selectById(Long employeeId){
        Employee employee = (Employee)MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            return mapper.selectById(employeeId);
        });
        return employee;
    }

    public Employee selectLeader(Long employeeId){
        Employee l = (Employee)MybatisUtils.executeQuery(sqlSession -> {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selectById(employeeId);
            Map params = new HashMap<>();
            Employee leader = null;
            if(employee.getLevel() < 7){
                //当前员工为技术岗，领导为部门经理
                params.put("level", 7);
                params.put("departmentId", employee.getDepartmentId());
                List<Employee> employees = mapper.selectByParams(params);
                leader = employees.get(0);
            } else if (employee.getLevel() == 7){
                //当前员工为 部门 经理，领导为总经理
                params.put("level", 8);
                List<Employee> employees = mapper.selectByParams(params);
                leader = employees.get(0);
            } else if (employee.getLevel() == 8){
                //员工为总经理，返回自己
                leader = employee;
            }
            return leader;
        });
        return l;
    }
}
