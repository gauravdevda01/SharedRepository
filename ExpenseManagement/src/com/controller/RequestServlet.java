package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public RequestServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		PrintWriter out=response.getWriter();
		out.println("Error");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String fName=request.getParameter("fname");
		String mName=request.getParameter("mname");
		String lName=request.getParameter("lname");
		String userId=request.getParameter("uId");
		String eMail=request.getParameter("email");
		String mobileNo=request.getParameter("mNum");
		
		if(fName.equals("") || mName.equals("") || lName.equals("") || userId.equals("") || eMail.equals("") || mobileNo.equals(""))
		{
			request.setAttribute("fieldMsg", "All fields should be filled");
			request.getRequestDispatcher("RequestPage.jsp").forward(request, response);
			return;
		}
		
		Pattern p=Pattern.compile("[\\w\\.]*\\w*.com");
		System.out.println(p);
		System.out.println("Email: "+eMail +" "+p.matcher(eMail).matches());
		if(!(p.matcher(eMail).matches()))
		{
			request.setAttribute("emailMsg", "Email should be like abc@xyz.com");
			request.getRequestDispatcher("RequestPage.jsp").forward(request, response);
			return;
		}
			
		Pattern p1=Pattern.compile("\\d{10}");
		
		if(!(p1.matcher(mobileNo).matches()))
		{
			request.setAttribute("mNumMsg", "Mobile number should be 10 digits");
			request.getRequestDispatcher("RequestPage.jsp").forward(request, response);
			return;
		}
			
		
	}

}
