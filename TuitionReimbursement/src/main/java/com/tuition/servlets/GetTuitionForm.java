package com.tuition.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuition.beans.TuitionForm;
import com.tuition.beans.User;
import com.tuition.dao.TuitionFormDAO;
import com.tuition.daoImpl.TuitionFormDAOImpl;

/**
 * Servlet implementation class GetTuitionForm
 */
public class GetTuitionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(request.getInputStream(), User.class);
		System.out.println(user);
		TuitionFormDAO tdi = new TuitionFormDAOImpl();
		TuitionForm form = tdi.getFormById(user.getUser_id());
		System.out.println(form);
		String formJSON = mapper.writeValueAsString(form);
		PrintWriter pw = response.getWriter();
		pw.write(formJSON);
		pw.close();
		response.setStatus(201);
	}

}
