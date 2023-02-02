package com.lxx.oa.service;

import com.lxx.oa.entity.User;
import org.junit.Test;

import javax.security.auth.login.LoginException;

import static org.junit.Assert.*;

/**
 * @author 林修贤
 * @date 2023/2/2
 * @description
 */
public class UserServiceTest {
    private UserService userService = new UserService();
    @Test
    public void checkLogin1() {
        User user = null;
        try {
            user = userService.checkLogin("test", "test");
        } catch (LoginException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }

    @Test
    public void checkLogin2() {
        User user = null;
        try {
            user = userService.checkLogin("test1", "test");
        } catch (LoginException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }

    @Test
    public void checkLogin3() {
        User user = null;
        try {
            user = userService.checkLogin("test", "test1");
        } catch (LoginException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}