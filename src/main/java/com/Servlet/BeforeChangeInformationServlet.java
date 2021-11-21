package com.Servlet;

import com.information.User;
import com.logic.UserService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

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
        UserService userService=new UserService();

        User user=userService.findUser(Integer.parseInt(ID));
        request.setAttribute("user",user);
        request.getRequestDispatcher("/JSP/changeInformation.jsp").forward(request,response);
    }
}
