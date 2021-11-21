package com.Servlet;

import com.information.Manager;
import com.logic.ManagerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String ManagerName = request.getParameter("Name");
        String ManagerPassword = request.getParameter("Password");
        Manager LoginManager = new Manager();
        LoginManager.setName(ManagerName);
        LoginManager.setPassword(ManagerPassword);
//        Manager LoginManager = new Manager();
//        Map<String, String[]> map = request.getParameterMap();
//        try {
//BeanUtils.populate(LoginManager,map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//       System.out.println(LoginManager);
        ManagerService managerService = new ManagerService();
        Manager manager = managerService.Login(LoginManager);
        if (manager != null) {
            response.sendRedirect("FindUserListServlet");
        } else {
            request.getRequestDispatcher("/FailServlet").forward(request,response);
        }

    }
}
