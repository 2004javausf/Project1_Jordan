package com.tuition.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuition.beans.TuitionForm;
import com.tuition.dao.TuitionFormDAO;
import com.tuition.daoImpl.TuitionFormDAOImpl;


public class TuitionFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		TuitionForm form = mapper.readValue(request.getInputStream(), TuitionForm.class);
		TuitionFormDAO tdi = new TuitionFormDAOImpl(); 
		tdi.addForm(form);
		response.setStatus(201);
	};
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		TuitionForm form = mapper.readValue(request.getInputStream(), TuitionForm.class);
		System.out.println(form);
		TuitionFormDAO tdi = new TuitionFormDAOImpl(); 
		tdi.updateForm(form);
		response.setStatus(201);
	}

}
