package com.jr.service;

import java.sql.SQLException;
import java.util.List;

import com.jr.dto.MemberVO;
import com.jr.dao.MemberDAO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memberList = memberDAO.selectMemberList();
		return memberList;
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
		return member;
	}

	@Override
	public int regist(MemberVO member) throws Exception {
		return memberDAO.insertMember(member);
	}

	@Override
	public int modify(MemberVO member) throws Exception {
		return memberDAO.updateMember(member);
	}

	@Override
	public int remove(String id) throws Exception {
		return memberDAO.deleteMember(id);
	}

}
