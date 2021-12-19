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

@WebServlet(name = "BeforeChangeInformationServlet", value = "/BeforeChangeInformationServlet")
public class BeforeChangeInformationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String ID = request.getParameter("ID");
        System.out.println(ID);
        UserService userService=new UserServiceImpl();

       User user = userService.findUser(Integer.parseInt(ID));
        System.out.println(user);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/JSP/changeInformation.jsp").forward(request, response);
    }
}
