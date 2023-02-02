package com.lxx.oa.mapper;

import com.lxx.oa.entity.User;
import com.lxx.oa.utils.MybatisUtils;

/**
 * @author 林修贤
 * @date 2023/2/2
 * @description 对用户表进行 增删改查 处理的类
 */
public class UserMapper {
    public User selectByUsername(String username){
        User user = (User) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("usermapper.selectByUsername", username));
        return user;
    }
}
