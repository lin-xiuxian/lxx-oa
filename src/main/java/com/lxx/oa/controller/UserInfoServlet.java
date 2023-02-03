package com.lxx.oa.controller;

import com.lxx.oa.entity.Employee;
import com.lxx.oa.entity.Node;
import com.lxx.oa.service.EmployeeService;
import com.lxx.oa.service.RbacService;
import com.lxx.oa.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description 用于获取与用户相关的信息
 */

@WebServlet("/api/user_info")
public class UserInfoServlet extends HttpServlet {
    private RbacService rbacService = new RbacService();
    private EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        String eid = request.getParameter("eid");
        List<Node> nodes = rbacService.selectNodeByUserId(Long.parseLong(uid));
        List<Map> treeList = new ArrayList<>();
        Map module = null;
        for(Node node: nodes){
            if(node.getNodeType() == 1){
                module = new LinkedHashMap();
                module.put("node", node);
                module.put("children", new ArrayList());
                treeList.add(module);
            } else if (node.getNodeType() == 2){
                List children = (List)module.get("children");
                children.add(node);
            }
        }
        Employee employee = employeeService.selectById(Long.parseLong(eid));
        String json = new ResponseUtils().put("nodeList", treeList).put("employee",employee).toJsonString();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
