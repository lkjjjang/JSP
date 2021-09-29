package com.lkjjjang.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String inputX = request.getParameter("x");
		String inputY = request.getParameter("y");
		String op = request.getParameter("operator");
			
		int x = 0;
		int y = 0;
		
		try {
			x = Integer.parseInt(inputX);
			y = Integer.parseInt(inputY);
		} catch (Exception e) {
			out.print("¼ýÀÚ¸¦ Àß¸ø ÀÔ·Â ÇÏ¼Ì½À´Ï´Ù.");
			return;
		}
		
		if (op.equals("µ¡¼À")) {
			out.print(x + y);
		} else {
			out.print(x - y);
		}
	}
}
