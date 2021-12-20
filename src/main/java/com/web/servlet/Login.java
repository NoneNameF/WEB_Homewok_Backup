package com.web.servlet;

import com.dao.ManagerDao;
import com.dao.impl.ManagerDaoImpl;
import com.domain.Manager;
import com.service.ManagerService;
import com.service.impl.ManagerServiceImpl;

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
        HttpSession session=request.getSession();
        Manager LoginManager = new Manager();
        LoginManager.setName(request.getParameter("Name"));
        LoginManager.setPassword(request.getParameter("Password"));

        ManagerService managerService=new ManagerServiceImpl();
        Manager manager = managerService.Login(LoginManager);
        if (manager != null) {
            session.setAttribute("Manager",manager);
            response.sendRedirect("FindUserListServlet");
        } else {
            request.getRequestDispatcher("/FailServlet").forward(request,response);
        }

    }
}
