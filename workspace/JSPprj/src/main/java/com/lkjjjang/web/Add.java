package com.lkjjjang.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String inputX = request.getParameter("x");
		String inputY = request.getParameter("y");
			
		int x = 0;
		int y = 0;
		
		try {
			x = Integer.parseInt(inputX);
			y = Integer.parseInt(inputY);
		} catch (Exception e) {
			out.print("숫자를 잘못 입력 하셨습니다.");
			return;
		}
				
		out.print(x + y);
	}
}
