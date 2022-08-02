package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<MemberVO> selectMemberList(Criteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			int offset = cri.getStartRowNum();
			int limit = cri.getPerPageNum();
			RowBounds rowBounds = new RowBounds(offset, limit);
			
			List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList", null, rowBounds);
			return memberList;
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			MemberVO member = (MemberVO) session.selectList("Member-Mapper.selectMemberById");
			return member;
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.insert("Member-Mapper.insertMember",member); 
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("Member-Mapper.updateMember",member); 
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.delete("Member-Mapper.deleteMember",id); 
		} catch (Exception e) {
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
	}

}
