package com.jr.service;

import java.sql.SQLException;
import java.util.List;

import com.jr.dto.MemberVO;

public interface MemberService {
	
	public int regist(MemberVO member) throws Exception;

	public int modify(MemberVO member) throws Exception;

	public int remove(String id) throws Exception;

	List<MemberVO> getMemberList() throws SQLException;

	MemberVO getMember(String id) throws SQLException;
}
