package com.jsp.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.command.PageMaker;
import com.jsp.dao.BoardDAO;
import com.jsp.dto.BoardVO;

public class BoardServiceImpl implements BoardService {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private BoardDAO BoardDAO;

	public void setBoardDAO(BoardDAO BoardDAO) {
		this.BoardDAO = BoardDAO;
	}

	@Override
	public Map<String, Object> getBoardList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();

			// 현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
			List<BoardVO> boardList = BoardDAO.selectSearchBoardList(session, cri);

			// 전체 board 개수
			int totalCount = BoardDAO.selectSearchBoardListCount(session, cri);

			// PageMaker 생성.
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(totalCount);

			dataMap.put("boardList", boardList);
			dataMap.put("pageMaker", pageMaker);

			return dataMap;
		} finally {
			session.close();
		}
	}

	@Override
	public BoardVO getBoard(int nno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			BoardVO board = BoardDAO.selectBoardByBno(session, nno);
			BoardDAO.increaseViewCount(session, nno);
			return board;
		} finally {
			session.close();
		}
	}

	@Override
	public BoardVO getBoardForModify(int bno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			BoardVO board = BoardDAO.selectBoardByBno(session, bno);
			return board;
		} finally {
			session.close();
		}
	}

	@Override
	public void regist(BoardVO Board) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			int nno = BoardDAO.selectBoardSequenceNextValue(session);
			Board.setBno(nno);
			BoardDAO.insertBoard(session, Board);
		} finally {
			session.close();
		}
	}

	@Override
	public void modify(BoardVO Board) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			BoardDAO.updateBoard(session, Board);
		} finally {
			session.close();
		}
	}

	@Override
	public void remove(int nno) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {

			BoardDAO.deleteBoard(session, nno);
		} finally {
			session.close();
		}
	}
}
