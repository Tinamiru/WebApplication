package com.jr.controller.member;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jr.action.Action;
import com.jr.context.ApplicationContext;

@WebServlet("/member/list123123")
public class MemberServlet extends HttpServlet {
	private Action action;

	{
		Map<String, Object> container = ApplicationContext.getApplicationContext();
		this.action = (Action) container.get("memberServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		try {
			url = action.process(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(url);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
