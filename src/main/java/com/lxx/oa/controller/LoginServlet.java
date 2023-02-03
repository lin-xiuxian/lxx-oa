package com.lxx.oa.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxx.oa.entity.User;
import com.lxx.oa.service.UserService;
import com.lxx.oa.utils.ResponseUtils;
import jdk.internal.dynalink.linker.LinkerServices;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 林修贤
 * @date 2023/2/3
 * @description
 */
@WebServlet("/api/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        //接收用户输入
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用业务逻辑
        ResponseUtils resp = null;
        try {
            User user = userService.checkLogin(username, password);
            //处理结果编码， 0 代表处理成功，非 0 代表处理失败
            resp = new ResponseUtils().put("user", user);
        } catch (LoginException e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        //返回json结果
        response.getWriter().println(resp.toJsonString());
    }
}
