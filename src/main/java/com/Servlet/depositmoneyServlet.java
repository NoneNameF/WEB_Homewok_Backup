package com.Servlet;

import com.information.User;
import com.logic.UserService;

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
        String ID=request.getParameter("ID");
        String Money=request.getParameter("Money");
        User user=new User();
        user.setID(Integer.parseInt(ID));
        user.setMoney(Double.parseDouble(String.format("%.2f", Double.parseDouble(Money))));
        System.out.println(user);
        UserService userService=new UserService();
        if(userService.depositMoney(user)) System.out.println("success");
        response.sendRedirect("FindUserListServlet");
    }
}
