package com.mvc.theam.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mvc.theam.dao.EmployeeDAOImpl;
import com.mvc.theam.dao.EmployeeDAOi;
import com.mvc.theam.model.Employee;
import com.mvc.theam.service.ImageProcess;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDAOi dao;
	private int id;
	private Employee e;
	private String v = "";
	private String imgName;
	private String btn;

	public EmployeeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao = new EmployeeDAOImpl();
		id = dao.getEmpId();
		request.setAttribute("id", id);
		request.getRequestDispatcher("/WEB-INF/view/employeeForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		e = new Employee();
		int ad=0;
		final String path = "C:/web/MVC_Theme/WebContent/images";
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {
					if (item.isFormField()) {
						String fieldname = item.getFieldName();
						String value = item.getString();
						if (fieldname.equals("id")) {
						 ad=Integer.parseInt(value);
							e.setId(Integer.parseInt(value));
						} else if (fieldname.equals("name")) {
							e.setName(value);
						} else if (fieldname.equals("email")) {
							e.setEmail(value);
						} else if (fieldname.equals("phone")) {
							e.setPhone(Long.parseLong(value));
						} else if (fieldname.equals("address")) {
							e.setAddress(value);
						} else if (fieldname.equals("gender")) {
							e.setGender(value);
						} else if (fieldname.equals("ms")) {
							e.setMs(value);
						} else if (fieldname.equals("doj")) {
							e.setDoj(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(value).getTime()));
						} else if (fieldname.equals("sports")) {
							e.setSports(value);
						} else if (fieldname.equals("music")) {
							e.setMusic(value);
						} else if (fieldname.equals("traveling")) {
							e.setTraveling(value);
						} else if (fieldname.equals("skills")) {
							v = v + value + ",";
						} else if (fieldname.equals("himg")) {
							e.setImage(value);
						} else if (fieldname.equals("btn")) {
							btn = value;
						}
						// out.println(fieldname + " : " + value + "</br>");

					} else if (item != null) {
						System.out.println(ad);
						imgName = ad + ".jpg";
						if (ImageProcess.processfile(item, imgName, path)) {
							e.setImage(imgName);
						}
					}
				}
				v = v.substring(0, v.length() - 1);
				e.setSkills(v);

				dao = new EmployeeDAOImpl();
				if (btn.equals("Add")) {
					dao.addEmployee(e);
				} else if (btn.equals("Update")) {
					dao.updateEmployee(e);
				}
				response.sendRedirect("IndexController");

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else {
			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}
	}
}
