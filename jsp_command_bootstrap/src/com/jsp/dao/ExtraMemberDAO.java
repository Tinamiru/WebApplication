package com.jsp.dao;

import java.sql.SQLException;

import com.jsp.dto.MemberVO;

public interface ExtraMemberDAO extends MemberDAO {
	
	public void insertMember(MemberVO member) throws SQLException;

	public void updateMember(MemberVO member) throws SQLException;

	public void deleteMember(String id) throws SQLException;
}
