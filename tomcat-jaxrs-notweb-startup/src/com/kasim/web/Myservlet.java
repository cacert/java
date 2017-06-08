package com.kasim.web;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value="/myservlet", name="Myservlet")
public class Myservlet extends HttpServlet {  
	@Override
	public void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException{
		resp.getWriter().write("success");
	}
	
}