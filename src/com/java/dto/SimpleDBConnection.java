package com.java.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SimpleDBConnection {

	public static void main(String[] args) throws Exception {

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "JSP", "JSP");

		String sql = "select * from member";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		List<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberVO member;
		while (rs.next()) {
			member = new MemberVO(rs.getString("id"),rs.getString("pwd"));
			member.setId(rs.getString("id"));
			member.setPwd(rs.getString("pwd"));
			member.setName(rs.getString("name"));
			member.setPhone(rs.getString("phone"));
			member.setEmail(rs.getString("email"));
			member.setAddress(rs.getString("address"));
			member.setPicture(rs.getString("picture"));

			memberList.add(member);
		}
		System.out.println(memberList);
	}

}
