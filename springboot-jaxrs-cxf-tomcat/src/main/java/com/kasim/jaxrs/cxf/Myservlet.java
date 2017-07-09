package com.kasim.jaxrs.cxf;

import javax.servlet.http.HttpServlet;

public class Myservlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException{
		resp.getWriter().write("success");
	}
	
}