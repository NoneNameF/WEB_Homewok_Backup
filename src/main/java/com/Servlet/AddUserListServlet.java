package com.Servlet;

import com.information.User;
import com.logic.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddUserListServlet", value = "/AddUserListServlet")
public class AddUserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String Name = request.getParameter("UserName1");
        String Sex = request.getParameter("Sex");
        String Age =request.getParameter("Age");
        User user=new User();
        user.setName(Name);
        if(Sex.equals("Man")) user.setSex("男");
        else user.setSex("女");
        user.setAge(Integer.parseInt(Age));
        UserService userService=new UserService();
        if(userService.addUser(user)) System.out.println("success");

        response.sendRedirect("FindUserListServlet");
    }
}
