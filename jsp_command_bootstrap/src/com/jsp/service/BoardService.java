package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.Criteria;
import com.jsp.dto.BoardVO;

public interface BoardService {
	

	// 목록조회
	Map<String, Object> getBoardList(Criteria cri) throws SQLException;
	
	// 상세보기
	BoardVO getBoard(int nno) throws SQLException;
	
	// 수정화면 상세
	BoardVO getBoardForModify(int nno) throws SQLException;

	// 등록
	void regist(BoardVO Board)throws SQLException;
	
	// 수정
	void modify(BoardVO Board) throws SQLException;

	// 삭제
	void remove(int nno) throws SQLException;
}
