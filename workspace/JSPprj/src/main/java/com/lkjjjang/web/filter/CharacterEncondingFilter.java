package com.lkjjjang.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// @WebFilter("/*") web.xml ���Ͽ��� ���ͼ��� �κ��� 
// ������̼����� ó����
@WebFilter("/*")
public class CharacterEncondingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {		

		// ���⼭ ���ڵ��� ���� �������� ������
		// ���ĺ��ʹ� ���ڵ� ���� �ʾƵ� ��
		request.setCharacterEncoding("UTF-8");
		// chain �� �������� ���۰��� �Ű�ü 
		chain.doFilter(request, response);
	}
}
