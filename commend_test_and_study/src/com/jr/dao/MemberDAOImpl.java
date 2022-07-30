package com.jr.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jr.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList");
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
	public int insertMember(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = 0;
		try {
			cnt = session.insert("Member-Mapper.insertMember", member);
		} catch (Exception e) {
			if (e instanceof SQLException)
				throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO member) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = 0;
		try {
			cnt = session.update("Member-Mapper.updateMember", member);
		} catch (Exception e) {
			if (e instanceof SQLException)
				throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = 0;
		try {
			cnt = session.delete("Member-Mapper.deleteMember", id);
		} catch (Exception e) {
			if (e instanceof SQLException)
				throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return cnt;
	}

}
