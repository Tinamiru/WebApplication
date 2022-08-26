package com.jsp.action.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.command.CriteriaCommand;
import com.jsp.controller.HttpRequestParameterAdapter;
import com.jsp.dto.BoardVO;
import com.jsp.service.BoardService;

public class BoardListAction implements Action {

	private BoardService BoardService;

	public void setBoardService(BoardService BoardService) {
		this.BoardService = BoardService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "/board/list";

		try {
			CriteriaCommand criCom = HttpRequestParameterAdapter.execute(request, CriteriaCommand.class);

			Criteria cri = criCom.toCriteria();

			Map<String, Object> dataMap = BoardService.getBoardList(cri);
			request.setAttribute("dataMap", dataMap);

		} catch (Exception e) {
			e.printStackTrace();
			// url="/error/500.jsp";
			throw e;
		}

		return url;
	}

}
