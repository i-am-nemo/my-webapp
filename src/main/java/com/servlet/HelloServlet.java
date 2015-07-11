 package com.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.servlet.save.LoginUser;

// com.lei.webapp.quickstart.HelloServlet
public class HelloServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

        /*PrintWriter out = response.getWriter();
        out.println( "Hello World!" );
        out.flush();
        out.close();*/
    	try {
    		String name=request.getParameter("name");
            String emailid=request.getParameter("emailid");
            
            LoginUser user = new LoginUser();
            user.setName(name);
            user.setEmailid(emailid);
            RequestDispatcher dispatcher=request.getRequestDispatcher("/Welcome.jsp");
            //Set the customer instance into request.Then only the customer object
            //will be available in the Welcome.jsp page
            request.setAttribute("cust",user);
            dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}
