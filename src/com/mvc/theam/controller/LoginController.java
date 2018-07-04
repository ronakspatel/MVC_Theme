package com.mvc.theam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.theam.dao.LoginDAOImpl;
import com.mvc.theam.dao.LoginDAOi;
import com.mvc.theam.model.Login;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   Login l;
   LoginDAOi dao;
    public LoginController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		l = new Login();
		l.setUserName(request.getParameter("username"));
		l.setPassword(request.getParameter("password"));
		dao = new LoginDAOImpl();
		if(dao.loginAuth(l)){
			response.sendRedirect("IndexController");
		} else {
			request.setAttribute("msg", "login failed.......");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}
		
	}

}
