package com.lxx.oa.controller;

import com.lxx.oa.entity.LeaveForm;
import com.lxx.oa.service.LeaveFormService;
import com.lxx.oa.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 林修贤
 * @date 2023/2/4
 * @description
 */
@WebServlet("/api/leave/*")
public class LeaveFormServlet extends HttpServlet {
    private LeaveFormService leaveFormService = new LeaveFormService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        //http://localhost/api/leave/create
        String uri = request.getRequestURI();
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);
        if(methodName.equals("create")){
            this.create(request, response);
        } else if (methodName.equals("list")){
            this.list(request, response);
        } else if (methodName.equals("audit")){

        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String strEmployeeId = request.getParameter("eid");
        String formType = request.getParameter("formType");
        //从1970到现在的毫秒数
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String reason = request.getParameter("reason");

        LeaveForm form = new LeaveForm();
        form.setEmployeeId(Long.parseLong(strEmployeeId));
        form.setFormType(Integer.parseInt(formType));
        form.setStartTime(new Date(Long.parseLong(startTime)));
        form.setEndTime(new Date(Long.parseLong(endTime)));
        form.setReason(reason);
        form.setCreateTime(new Date());
        ResponseUtils resp = null;
        try{
            leaveFormService.createLeaveForm(form);
            resp = new ResponseUtils();
        } catch (Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        response.getWriter().println(resp.toJsonString());
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String employeeId = request.getParameter("eid");
        ResponseUtils resp = null;
        try{
            List<Map> formList = leaveFormService.getLeaveFormList("process", Long.parseLong(employeeId));
            resp = new ResponseUtils().put("list", formList);
        } catch(Exception e){
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        response.getWriter().println(resp.toJsonString());
    }
}