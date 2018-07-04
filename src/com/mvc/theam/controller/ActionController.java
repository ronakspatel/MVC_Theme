package com.mvc.theam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.theam.dao.EmployeeDAOImpl;
import com.mvc.theam.dao.EmployeeDAOi;
import com.mvc.theam.model.Employee;

/**
 * Servlet implementation class ActionController
 */
@WebServlet("/ActionController")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int hid;
	private String btn;
	private Employee e;
	private EmployeeDAOi dao;

	public ActionController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		hid = Integer.parseInt(request.getParameter("hid"));
		btn = request.getParameter("btn");
		dao = new EmployeeDAOImpl();
		if (btn.equals("View")) {
			e = dao.viewEmployee(hid);
			request.setAttribute("e", e);
			request.getRequestDispatcher("/WEB-INF/view/disp.jsp").forward(request, response);
		}else if (btn.equals("Edit")) {
			e = dao.viewEmployee(hid);
			request.setAttribute("e", e);
			request.getRequestDispatcher("/WEB-INF/view/employeeForm.jsp").forward(request, response);
		}else if (btn.equals("Delete")) {
			dao.deleteEmployee(hid);
			response.sendRedirect("IndexController");
		}
	}
}
