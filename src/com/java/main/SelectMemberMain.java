package com.java.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.java.dto.MemberVO;

public class SelectMemberMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요.");
		String id = sc.nextLine();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "JSP", "JSP");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		try {
			String sql = "select *" + " from member" + " where id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			MemberVO member = new MemberVO();

			if (rs.next()) {
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setPicture(rs.getString("picture"));

			}
			System.out.println(member.getName());

		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}

	}
}
