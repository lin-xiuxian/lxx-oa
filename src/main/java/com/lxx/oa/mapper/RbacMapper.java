package com.lxx.oa.mapper;

import com.lxx.oa.entity.Node;
import com.lxx.oa.utils.MybatisUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public class RbacMapper {
    public List<Node> selectNodeByUserId(Long userId){
        List list = (List)MybatisUtils.executeQuery(sqlSession -> sqlSession.selectList("rbacmapper.selectNodeByUserId", userId));
        return list;
    }
}
