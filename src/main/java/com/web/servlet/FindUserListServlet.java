package com.web.servlet;

import com.domain.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindUserListServlet", value = "/FindUserListServlet")
public class FindUserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserService userService =new UserServiceImpl();
        List<User> users = userService.findAll();
        request.setAttribute("users",users);
        request.getRequestDispatcher("/JSP/list.jsp").forward(request,response);
    }
}
