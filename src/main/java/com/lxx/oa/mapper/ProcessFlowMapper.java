package com.lxx.oa.mapper;

import com.lxx.oa.entity.ProcessFlow;

import java.util.List;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public interface ProcessFlowMapper {
    public void insert(ProcessFlow processFlow);
    public void update(ProcessFlow processFlow);
    public List<ProcessFlow> selectByFormId(Long formId);
}
