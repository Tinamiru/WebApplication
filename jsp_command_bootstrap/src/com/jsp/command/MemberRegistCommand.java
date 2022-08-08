package com.jsp.command;

import java.util.Date;

import com.jsp.dto.MemberVO;

public class MemberRegistCommand {

	private String id;
	private String pwd;
	private String name = "___";
	private String[] phone;
	private String email;
	private String picture;
	private String authority;

	public MemberVO toMemberVO() {

		String phone = "";

		for (String data : this.phone) {
			phone += data;
		}

		// MemberVO setting
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setPhone(phone);
		member.setEmail(email);
		member.setPicture(picture);
		member.setAuthority(authority);
		member.setName(name);
		member.setRegDate(new Date());

		return member;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String[] phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
