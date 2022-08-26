package com.jsp.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.service.BoardService;
import com.jsp.service.NoticeService;

public class BoardRemoveAction implements Action {

	private BoardService boardService;

	public void setNoticeService(BoardService boardService) {
		this.boardService = boardService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/remove_success";

		try {
			int bno = Integer.parseInt(request.getParameter("bno"));

			boardService.remove(bno);

		} catch (Exception e) {
			e.printStackTrace();
			url = null;
			throw e;
		}

		return url;
	}

}
