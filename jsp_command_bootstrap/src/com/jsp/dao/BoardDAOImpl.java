package com.jsp.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.jsp.action.Action;
import com.jsp.command.Criteria;
import com.jsp.dto.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	
	@Override
	public List<BoardVO> selectSearchBoardList(SqlSession session, Criteria cri) throws SQLException {

		int startRow = cri.getStartRowNum()+1;
		int endRow = startRow+cri.getPerPageNum()-1;		
		
		Map<String, Object> dataParam = new HashMap<String, Object>();
		dataParam.put("startRow", startRow);
		dataParam.put("endRow", endRow);
		dataParam.put("searchType", cri.getSearchType());
		dataParam.put("keyword", cri.getKeyword());

		List<BoardVO> boardList = session.selectList("Board-Mapper.selectSearchBoardList", dataParam);

		return boardList;
	}

	@Override
	public int selectSearchBoardListCount(SqlSession session, Criteria cri) throws SQLException {
		int count = session.selectOne("Board-Mapper.selectSearchBoardListCount", cri);
		return count;
	}

	@Override
	public BoardVO selectBoardByBno(SqlSession session, int bno) throws SQLException {
		BoardVO Board = session.selectOne("Board-Mapper.selectBoardByBno", bno);
		return Board;
	}

	@Override
	public void increaseViewCount(SqlSession session, int bno) throws SQLException {
		session.update("Board-Mapper.increaseViewCount", bno);

	}

	@Override
	public int selectBoardSequenceNextValue(SqlSession session) throws SQLException {
		int seq_num = session.selectOne("Board-Mapper.selectBoardSequenceNextValue");
		return seq_num;
	}

	@Override
	public void insertBoard(SqlSession session, BoardVO Board) throws SQLException {
		session.update("Board-Mapper.insertBoard", Board);

	}

	@Override
	public void updateBoard(SqlSession session, BoardVO Board) throws SQLException {
		session.update("Board-Mapper.updateBoard", Board);
	}

	@Override
	public void deleteBoard(SqlSession session, int bno) throws SQLException {
		session.update("Board-Mapper.deleteBoard", bno);
	}
}
