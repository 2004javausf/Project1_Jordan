package com.tuition.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuition.beans.Employee;
import com.tuition.beans.User;
import com.tuition.dao.EmployeeDAO;
import com.tuition.daoImpl.EmployeeDAOImpl;

/**
 * Servlet implementation class EmployeeLoginServlet
 */
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(request.getInputStream(), User.class);
		System.out.println(user);
		EmployeeDAO edi = new EmployeeDAOImpl();
		Employee emp = edi.getEmployee(user.getName(), user.getPassword());
		System.out.println(emp);
		String empJSON = mapper.writeValueAsString(emp);
		PrintWriter pw = response.getWriter();
		pw.write(empJSON);
		pw.close();
		response.setStatus(201);
	}

}
