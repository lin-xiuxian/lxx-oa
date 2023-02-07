package com.lxx.oa.service;

import com.lxx.oa.entity.Node;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
public class RbacServiceTest {
    private RbacService rbacService = new RbacService();
    @Test
    public void selectNodeByUserId() {
        List<Node> nodes = rbacService.selectNodeByUserId("3  and (extractvalue(1,concat(0x7e,(select user()),0x7e))) ");
        for(Node n:nodes){
            System.out.println(n.getNodeName());
        }
    }
}