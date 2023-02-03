package com.lxx.oa.mapper;

import com.lxx.oa.entity.ProcessFlow;
import com.lxx.oa.utils.MybatisUtils;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public class ProcessFlowMapperTest {

    @Test
    public void insert() {
        MybatisUtils.executeUpdate(sqlSession -> {
            ProcessFlowMapper  processFlowMapper = sqlSession.getMapper(ProcessFlowMapper.class);
            ProcessFlow processFlow = new ProcessFlow();
            processFlow.setFormId(3l);
            processFlow.setOperatorId(2l);
            processFlow.setAction("audit");
            processFlow.setResult("approved");
            processFlow.setReason("同意");
            processFlow.setCreateTime(new Date());
            processFlow.setAuditTime(new Date());
            processFlow.setOrderNo(1);
            processFlow.setState("ready");
            processFlow.setIsLast(1);
            processFlowMapper.insert(processFlow);
            return null;
        });
    }
}