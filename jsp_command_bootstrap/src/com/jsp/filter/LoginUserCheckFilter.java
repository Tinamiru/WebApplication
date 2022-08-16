package com.jsp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.controller.JSPViewResolver;
import com.jsp.dto.MemberVO;

public class LoginUserCheckFilter implements Filter {

	private List<String> exURLs = new ArrayList<String>();

	public void init(FilterConfig fConfig) throws ServletException {
		String excludeURLNames = fConfig.getInitParameter("exclude");

		StringTokenizer st = new StringTokenizer(excludeURLNames, ",");
		while (st.hasMoreTokens()) {
			exURLs.add(st.nextToken().trim());
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;

		String reqUrl = httpReq.getRequestURI().substring(httpReq.getContextPath().length());

		if (excludeCheck(reqUrl)) {
			chain.doFilter(request, response);
			return;
		}

		// login check
		HttpSession session = httpReq.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		// login 확인
		if (loginUser == null) {
			httpReq.setAttribute("viewName", "redirect:/common/loginForm.do");
			JSPViewResolver.view(httpReq, httpResp);
		} else {
			chain.doFilter(request, response);
		}
	}

	private boolean excludeCheck(String url) {
		boolean result = false;
		System.out.println("url len: " + url.length());
		result = result || url.length() <= 1;
		System.out.println("up: "+result);
		for (String exURL : exURLs) {
			System.out.println("url contains: "+url.contains(exURL));
			result = result || url.contains(exURL);
		}
		System.out.println("dw: "+result);
		System.out.println();
		return result;
	}

	public void destroy() {
	}

}
