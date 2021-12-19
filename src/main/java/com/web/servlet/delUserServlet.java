package com.web.servlet;

import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelUserListServlet", value = "/DelUserListServlet")
public class delUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserService userService=new UserServiceImpl();

        if(userService.deleteUser(Integer.parseInt(request.getParameter("ID")))) response.sendRedirect("FindUserListServlet");
        else response.sendRedirect("FailServlet");
    }
}
