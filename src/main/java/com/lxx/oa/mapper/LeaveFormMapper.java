package com.lxx.oa.mapper;

import com.lxx.oa.entity.LeaveForm;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public interface LeaveFormMapper {
    public void insert(LeaveForm from);
    public List<Map> selectByParams(@Param("pf_state") String pfState
            , @Param("pf_operator_id") Long pfOperatorId);
}
