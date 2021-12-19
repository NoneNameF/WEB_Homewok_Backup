package com.web.servlet;

import com.dao.ManagerDao;
import com.dao.impl.ManagerDaoImpl;
import com.domain.Manager;

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
        HttpSession session=request.getSession();
        Manager LoginManager = new Manager();
        LoginManager.setName(ManagerName);
        LoginManager.setPassword(ManagerPassword);
        ManagerDao managerFun = new ManagerDaoImpl();
        Manager manager = managerFun.Login(LoginManager);
        if (manager != null) {
            session.setAttribute("Manager",manager);
            response.sendRedirect("FindUserListServlet");
        } else {
            request.getRequestDispatcher("/FailServlet").forward(request,response);
        }

    }
}
