package com.lkjjjang.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// @WebFilter("/*") web.xml 파일에서 필터설정 부분을 
// 어노테이션으로 처리함
@WebFilter("/*")
public class CharacterEncondingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {		

		// 여기서 인코딩후 다음 페이지에 전달함
		// 이후부터는 인코딩 하지 않아도 됨
		request.setCharacterEncoding("UTF-8");
		// chain 은 필터이후 동작과의 매개체 
		chain.doFilter(request, response);
	}
}
