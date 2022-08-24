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
		
		CriteriaCommand criCom = HttpRequestParameterAdapter.execute(request, CriteriaCommand.class);
		
		Criteria cri = criCom.toCriteria();
		
		Map<String,Object> dataMap = BoardService.getBoardList(cri);
		
		List<BoardVO> tests = (List<BoardVO>) dataMap.get("boardList");
		
		BoardVO test = tests.get(1);
		System.out.println(test.getRegDate());
		
		
		request.setAttribute("dataMap",dataMap);
		
		return url;
	}

}








