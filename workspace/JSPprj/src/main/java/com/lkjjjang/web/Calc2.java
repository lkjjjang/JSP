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
		// �������������� ������ ���� ����ִ� ��ü
		// application �����
		ServletContext servletContext = request.getServletContext();
		
		// ������ �̿��� �������� �����Ͽ� ����ڸ� ����
		// session �����
		HttpSession httpSession = request.getSession();
		
		// ��Ű�� �̿��� ����� ���� ����
		// ��Ű�� �迭�θ� ������
		Cookie[] cookies = request.getCookies();
		
		// ����� ���� ��ü
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
			// ��Ű���� �ݵ�� ���ڿ��� ��������
			Cookie valueCookie = new Cookie("value", String.valueOf(value));
			Cookie opCookie = new Cookie("operator", operator);
			
			// ������ ��ο����� ��Ű�� ������ �ֵ��� ����
			valueCookie.setPath("/calc2");
			opCookie.setPath("/calc2");

			// ��Ű�� ��ȯ
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
		}
		
		/* session ����� ���
		if (operator.equals("=")) {
			// = �� ��� ���
			// �������������� ������ ���� ����ִ� ��ü���� 
			// �ʿ��� ���� Ű������ ������ ������
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
			// ���ǰ� +,- �� ��� ���� ���� �ϰ� ������ ���� 
			// ���ǿ� ����
			httpSession.setAttribute("value", result);
			httpSession.setAttribute("operator", operator);
		}*/
		
		/* servletContex ��� application ����� ���
		if (operator.equals("=")) {
			// = �� ��� ���
			// �������������� ������ ���� ����ִ� ��ü���� 
			// �ʿ��� ���� Ű������ ������ ������
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
			// ���ǰ� +,- �� ��� ���� ���� �ϰ� ������ ���� 
			// application �� ����
			servletContext.setAttribute("value", result);
			servletContext.setAttribute("operator", operator);
		}*/
	}
}
