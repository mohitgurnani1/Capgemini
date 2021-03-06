package com.flp.ems.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.flp.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class removeServlet
 */
@WebServlet("/removeServlet")
public class removeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String key=request.getParameter("remove");
		String value=request.getParameter("ValueOfKey");
	
		String value2=request.getParameter("emailId");
		
		WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		EmployeeServiceImpl e=applicationContext.getBean("service",EmployeeServiceImpl.class);
		
		boolean flag=false;
		if(key!=null && value!=null && key.isEmpty()==false && value.isEmpty()==false)
			flag=e.RemoveEmployee(key,value);
		else
			flag=e.RemoveEmployee("emailId", value2);

		RequestDispatcher rd=request.getRequestDispatcher("remove.jsp");
		rd.include(request, response);
		PrintWriter out=response.getWriter();
		
		if(flag)
			out.write("<font color='red'>Employee has been Successfully Removed");
		else
			out.write("<font color='red'>Employee couldnt be Removed");
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
