package com.jsp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dao.MemberDAO;
import com.jsp.dto.MemberVO;

public class MockMemberDAO implements MemberDAO {

	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		List<MemberVO> memberList=new ArrayList<MemberVO>();
		
		for(int i=0;i<10;i++) {
			memberList.add(new MemberVO("mimi"+i,"mimi"+i));
		}
		return memberList;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
	
		return new MemberVO(id,id);
	}

}
