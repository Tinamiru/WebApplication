package com.jr.dao;

import java.sql.SQLException;
import java.util.List;

import com.jr.dto.MemberVO;

public interface MemberDAO {

	List<MemberVO> selectMemberList() throws SQLException;

	MemberVO selectMemberById(String id) throws SQLException;

	public int insertMember(MemberVO member) throws SQLException;

	public int updateMember(MemberVO member) throws SQLException;

	public int deleteMember(String id) throws SQLException;
}