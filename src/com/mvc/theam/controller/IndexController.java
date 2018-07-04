package com.mvc.theam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.theam.dao.EmployeeDAOImpl;
import com.mvc.theam.dao.EmployeeDAOi;
import com.mvc.theam.model.Employee;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAOi dao;
	private List<Employee> ls;
	
    public IndexController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao = new EmployeeDAOImpl();
		ls = dao.getEmployee();
		request.setAttribute("ls", ls);
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

}
