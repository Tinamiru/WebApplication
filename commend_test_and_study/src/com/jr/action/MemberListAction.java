package com.jr.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jr.context.ApplicationContext;
import com.jr.dto.MemberVO;
import com.jr.service.MemberService;

public class MemberListAction implements Action {
	private MemberService service;
	{
		Map<String, Object> container = ApplicationContext.getApplicationContext();
		this.service = (MemberService) container.get("memberService");
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String url = "/WEB-INF/views/member/list.jsp";

		List<MemberVO> memberList;
		try {
			memberList = service.getMemberList();
			request.setAttribute("memberList", memberList);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "/WEB-INF/views/error/500.jsp";
		}
		return url;
	}

}
