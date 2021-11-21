package com.Servlet;

import com.information.User;
import com.logic.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeInformationServlet", value = "/ChangeInformationServlet")
public class ChangeInformationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
String ID=request.getParameter("ID");
        String Name = request.getParameter("UserName1");
        String Sex = request.getParameter("Sex");
        String Age =request.getParameter("Age");
        String Money=request.getParameter("Money");
        User user=new User();
        user.setName(Name);
        user.setID(Integer.parseInt(ID));
        user.setAge(Integer.parseInt(Age));
        if(Sex.equals("Man")) user.setSex("男");
        else user.setSex("女");
        user.setMoney(Double.parseDouble(Money));
        System.out.println(user);
        UserService userService=new UserService();
        if(userService.changeUser(user)) System.out.println("success");
        response.sendRedirect("FindUserListServlet");
    }
}
