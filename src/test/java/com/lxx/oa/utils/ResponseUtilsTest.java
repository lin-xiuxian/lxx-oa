package com.lxx.oa.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public class ResponseUtilsTest {

    @Test
    public void put1() {
        ResponseUtils resp = new ResponseUtils("LoginException", "密码错误").put("class", "XXXClass").put("name", "lxx");
        String json = resp.toJsonString();
        System.out.println(json);
    }

    @Test
    public void put2() {
        System.out.println(new ResponseUtils("LoginException", "密码错误").put("class", "XXXClass").put("name", "lxx").toJsonString());
    }
}