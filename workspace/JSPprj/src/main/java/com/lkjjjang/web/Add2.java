package com.lkjjjang.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String[] nums = request.getParameterValues("num");

		int result = 0;
			
		try {
			for (int i = 0; i < nums.length; i++) {
				int num = Integer.parseInt(nums[i]);
				result += num;
			}
		} catch (Exception e) {
			out.print("숫자를 잘못 입력 하셨습니다.");
			return;
		}
		
		out.print(result);
	}
}
