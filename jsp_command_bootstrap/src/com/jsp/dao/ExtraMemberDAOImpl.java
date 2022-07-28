package com.jsp.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dto.MemberVO;

public class ExtraMemberDAOImpl extends MemberDAOImpl implements ExtraMemberDAO {
	
	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}


	@Override
	public void insertMember(MemberVO member) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
