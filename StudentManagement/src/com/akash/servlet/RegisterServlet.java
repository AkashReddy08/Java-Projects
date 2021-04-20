package com.akash.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akash.model.Student;
import com.akash.service.StudentService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	
	
	
	private static final long serialVersionUID = 1L;
    private StudentService studentService;
    public void init() {
    	studentService = new StudentService();
    	
    }
    
    

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlettttttttttttttttttttt");
		PrintWriter pw = null;
		RequestDispatcher rd = null;
		int count = 0;
		pw = response.getWriter();
		response.setContentType("text/html");
		Student s = new Student();
		s.setName(request.getParameter("name"));
		s.setPassword(request.getParameter("password"));
		s.setEmail(request.getParameter("email"));
		s.setMobileNo(Long.parseLong(request.getParameter("mobileNo")));
		try {
			System.out.println("tryyyyyyyyyyy");

			count= studentService.insertStudent(s);
			if(count==0) {
				System.out.println("count"+count);

				rd= request.getRequestDispatcher("register.jsp");
				rd.include(request, response);
			}
			else {
				System.out.println("count"+count);

				rd= request.getRequestDispatcher("registerSuccess.jsp");
				rd.forward(request, response);

				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
