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

@WebServlet(name = "depositMoneyServlet", value = "/depositMoneyServlet")
public class depositmoneyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserService userService=new UserServiceImpl();
        boolean STA = userService.depositMoney(
                Integer.parseInt(request.getParameter("ID")),
                Double.parseDouble(request.getParameter("Money"))
        );
        System.out.println("test");
        if(STA) response.sendRedirect("FindUserListServlet");
//        response.sendRedirect("FailServlet");
    }
}
