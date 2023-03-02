package com.lxx.oa.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.lxx.oa.entity.LeaveForm;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * @author 林修贤
 * @date 2023/2/6
 * @description
 */
public class JsonToObjService {
    public LeaveForm creatForm(String eid, String formType, String startTime, String endTime, String reason){
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
        String ObjString = reason;
        LeaveForm leaveForm = new LeaveForm();
        JSONObject jsonObject = JSON.parseObject(ObjString);
        try {
            BeanUtils.copyProperties(leaveForm, jsonObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return leaveForm;
    }
}
