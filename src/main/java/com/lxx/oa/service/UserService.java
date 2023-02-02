package com.lxx.oa.service;

import com.lxx.oa.entity.User;
import com.lxx.oa.mapper.UserMapper;

import javax.security.auth.login.LoginException;

/**
 * @author 林修贤
 * @date 2023/2/2
 * @description
 */
public class UserService {
    private UserMapper userMapper = new UserMapper();

    /**
     * 根据前台输入进行登录验证
     * @param username 前台输入用户名
     * @param password 前台输入用户密码
     * @return 校验通过后返回包含用户数据的 User 实体类
     * @throws LoginException 用户登录异常
     */
    public User checkLogin(String username, String password) throws LoginException {
        User user = userMapper.selectByUsername(username);
        if(user == null){
            throw new LoginException("用户名不存在");
        }
        if(!password.equals(user.getPassword())){
            throw new LoginException("密码错误");
        }
        return user;
    }
}
