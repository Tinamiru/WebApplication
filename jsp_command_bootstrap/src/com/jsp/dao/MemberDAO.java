package com.jsp.dao;

import java.sql.SQLException;
import java.util.List;

import com.jsp.command.Criteria;
import com.jsp.dto.MemberVO;

public interface MemberDAO {

	List<MemberVO> selectMemberList(Criteria cri) throws SQLException;

	MemberVO selectMemberById(String id) throws SQLException;

	public void insertMember(MemberVO member) throws SQLException;

	public void updateMember(MemberVO member) throws SQLException;

	public void deleteMember(String id) throws SQLException;
}
