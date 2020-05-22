package com.tuition.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuition.beans.User;
import com.tuition.dao.UserDAO;
import com.tuition.daoImpl.UserDAOImpl;

/**
 * Servlet implementation class Users
 */
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		String infoJSON;
		UserDAO udi = new UserDAOImpl();
		try {
			infoJSON = mapper.writeValueAsString(udi.getUsers());
			response.setContentType("application/json");
			pw.print(infoJSON);
		}catch(JsonProcessingException e ) {
			e.printStackTrace();
		}
		pw.flush();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(request.getInputStream(), User.class);
		UserDAO udi = new UserDAOImpl();
		udi.createUser(user);	
	}

}
