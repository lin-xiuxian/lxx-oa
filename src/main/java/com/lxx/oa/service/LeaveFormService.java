package com.lxx.oa.service;

import com.lxx.oa.entity.Employee;
import com.lxx.oa.entity.LeaveForm;
import com.lxx.oa.entity.ProcessFlow;
import com.lxx.oa.mapper.EmployeeMapper;
import com.lxx.oa.mapper.LeaveFormMapper;
import com.lxx.oa.mapper.ProcessFlowMapper;
import com.lxx.oa.utils.MybatisUtils;

import java.util.Date;

/**
 * @author 林修贤
 * @date 2023/2/4
 * @description 完成多级请假流程的业务逻辑
 */
public class LeaveFormService {
    /**
     * 创建请假单
     * @param form 前端输入的请假单据
     * @return 持久化之后的请假单对象
     */
    public LeaveForm createLeaveForm(LeaveForm form) {
        MybatisUtils.executeUpdate(sqlSession -> {
            //1. 持久化form表单数据，8级一下员工表单状态为 processing, 8级（总经理）状态为 approved
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.selectById(form.getEmployeeId());
            if(employee.getLevel() == 8){
                form.setState("approved");
            } else {
                form.setState("processing");
            }
            LeaveFormMapper leaveFormMapper = sqlSession.getMapper(LeaveFormMapper.class);
            leaveFormMapper.insert(form);
            //2. 增加一条流程数据，说明表单已提交，状态为 complete
            ProcessFlowMapper processFlowMapper = sqlSession.getMapper(ProcessFlowMapper.class);
            ProcessFlow flow1 = new ProcessFlow();
            flow1.setFormId(form.getFormId());
            flow1.setOperatorId(employee.getEmployeeId());
            flow1.setAction("apply");
            flow1.setCreateTime(new Date());
            flow1.setOrderNo(1);
            flow1.setState("complete");
            flow1.setIsLast(0);
            processFlowMapper.insert(flow1);
            //3. 分情况创建其余流程数据
            //3.1 7级一下员工，生成 部门 经理审批任务，请假时间大于 72 小时，还需生成总经理审批任务
            //3.2 7级员工，仅生成总经理审批任务
            //3.3 8级员工，生成总经理审批任务，系统自动通过
            return null;
        });
        return null;
    }
}
