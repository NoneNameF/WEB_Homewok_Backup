package com.web.servlet;

import com.domain.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUserListServlet", value = "/AddUserListServlet")
public class AddUserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserService userService=new UserServiceImpl();

        User user =userService.creatUser(
                request.getParameter("UserName"),
                Integer.parseInt(request.getParameter("State")),
                Integer.parseInt(request.getParameter("layer")),
                Integer.parseInt(request.getParameter("room")),
                0
        );

        if (userService.addUser(user)) response.sendRedirect("FindUserListServlet");
        else response.sendRedirect("FailServlet");
    }
}
