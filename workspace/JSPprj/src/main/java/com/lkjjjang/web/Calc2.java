package com.lkjjjang.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 이전페이지에서 저장한 값이 들어있는 개체
		// application 저장소
		ServletContext servletContext = request.getServletContext();
		
		// 세션을 이용해 브라우저에 저장하여 사용자를 구분
		// session 저장소
		HttpSession httpSession = request.getSession();
		
		// 쿠키를 이용해 사용자 정보 저장
		// 쿠키는 배열로만 보내짐
		Cookie[] cookies = request.getCookies();
		
		// 출력을 위한 개체
		PrintWriter out = response.getWriter();
		
		String value = request.getParameter("value");
		String operator = request.getParameter("operator");
		
		int v = 0;
		if (!value.equals("")) {
			v = Integer.parseInt(value);
		}

		if (operator.equals("=")) {
			int x = 0;
			int y = v;
			String op = "";

			for (Cookie c : cookies) {
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
				} else if (c.getName().equals("operator")) {
					op = c.getValue();
				}
			}
			
			int result = 0;
			if (op.equals("+")) {
				result = x + y;
			} else {
				result = x - y;
			}
			out.print(result);
			System.out.printf("%d %s %d = %d", x, op, y, x + y);
		} else {
			// 쿠키값은 반드시 문자열로 보내야함
			Cookie valueCookie = new Cookie("value", String.valueOf(value));
			Cookie opCookie = new Cookie("operator", operator);
			
			// 지정된 경로에서만 쿠키를 받을수 있도록 설정
			valueCookie.setPath("/calc2");
			opCookie.setPath("/calc2");

			// 쿠키를 반환
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
		}
		
		/* session 저장소 사용
		if (operator.equals("=")) {
			// = 일 경우 계산
			// 이전페이지에서 저장한 값이 들어있는 개체에서 
			// 필요한 값을 키값으로 매핑해 가져옴
			int x = (Integer) httpSession.getAttribute("value");
			int y = result;
			String op = (String) httpSession.getAttribute("operator");
			
			if (op.equals("+")) {
				result = x + y;
			} else {
				result = x - y;
			}	
			out.print(result);
		} else {
			// 오피가 +,- 일 경우 값을 저장 하고 페이지 내림 
			// 세션에 저장
			httpSession.setAttribute("value", result);
			httpSession.setAttribute("operator", operator);
		}*/
		
		/* servletContex 사용 application 저장소 사용
		if (operator.equals("=")) {
			// = 일 경우 계산
			// 이전페이지에서 저장한 값이 들어있는 개체에서 
			// 필요한 값을 키값으로 매핑해 가져옴
			int x = (Integer) servletContext.getAttribute("value");
			int y = result;
			String op = (String) servletContext.getAttribute("operator");
			
			if (op.equals("+")) {
				result = x + y;
			} else {
				result = x - y;
			}	
			out.print(result);
		} else {
			// 오피가 +,- 일 경우 값을 저장 하고 페이지 내림 
			// application 에 저장
			servletContext.setAttribute("value", result);
			servletContext.setAttribute("operator", operator);
		}*/
	}
}
