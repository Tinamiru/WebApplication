package com.jsp.controller;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.jsp.context.ApplicationContext;
import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.service.MemberServiceImpl;

public class InitApplicationContextServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
//		System.out.println("init process...");

		Map<String, Object> map = ApplicationContext.getApplicationContext();

		map.put("memberService", new MemberServiceImpl());
		map.put("memberDAO", new MemberDAOImpl());
		map.put("sqlSessionFactory", new OracleMybatisSqlSessionFactory());
		
		MemberServiceImpl memberService = ((MemberServiceImpl) map.get("memberService"));
		MemberDAO memberDAO = (MemberDAO) map.get("memberDAO");
		memberService.setMemberDAO(memberDAO);
		
		MemberDAOImpl memberDAOImpl = (MemberDAOImpl) map.get("memberDAO");
		OracleMybatisSqlSessionFactory sqlSessionFactory = (OracleMybatisSqlSessionFactory) map.get("sqlSessionFactory");
		memberDAOImpl.setSqlSessionFactory(sqlSessionFactory);
	}
}
