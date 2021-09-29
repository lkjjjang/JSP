package com.lkjjjang.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/hi")
public class Nana extends HttpServlet {
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String cnt = request.getParameter("cnt");
		int reqCount = 1;
		
		if (cnt != null && !cnt.equals("")) {
			reqCount = Integer.parseInt(cnt);
		}
		
		for (int i = 0; i < reqCount; i++) {
			out.printf((i + 1) + ": ¾È³ç hello<br >");
		}
		
	}

}
