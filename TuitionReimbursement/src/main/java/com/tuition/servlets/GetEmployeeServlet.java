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
 * Servlet implementation class GetEmployeeServlet
 */
public class GetEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();//Create mapper object
		User user = mapper.readValue(request.getInputStream(), User.class); // Deserialize the object and put it to a java object.
		System.out.println(user);
		System.out.println("inside /getEmployee");
		EmployeeDAO edi = new EmployeeDAOImpl();// Create an instance of my DAOImpl class which will handle and database procedures.
		Employee emp = edi.getEmployeeByUserId(user.getUser_id()); //Make an instance of my Employee bean which is being returned from my DAOImpl 'getEmployee' method.
		System.out.println(emp);
		String empJSON = mapper.writeValueAsString(emp);//This will take my Java Object and write it as a JSON Object and made it as String JSON Object
		PrintWriter pw = response.getWriter();//Getting an instance of a PrintWriter object which the response.getWriter() is set to.
		pw.write(empJSON);//Not sure if this is necessary but this will write the response will NOW be the JSON object we created and make it the response made available for grabs by the front end.
		pw.close();//Self Explanatory.
		response.setStatus(201);
	}

}
