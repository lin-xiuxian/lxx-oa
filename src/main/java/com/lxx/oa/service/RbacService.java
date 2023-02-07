package com.lxx.oa.service;

import com.lxx.oa.entity.Node;
import com.lxx.oa.mapper.RbacMapper;

import java.util.List;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public class RbacService {
    private RbacMapper rbacMapper = new RbacMapper();
    public List<Node> selectNodeByUserId(String userId){
        return rbacMapper.selectNodeByUserId(userId);
    }
}
