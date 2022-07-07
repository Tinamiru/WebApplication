package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.datasource.JDBCDataSource;
import com.java.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private Connection conn;

	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		JDBCDataSource dataSource = JDBCDataSource.getInstance();
		try {
			conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "select * from member";
		ResultSet rs;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		List<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberVO member;

		while (rs.next()) {
			member = new MemberVO();

			member.setId(rs.getString("id"));
			member.setPwd(rs.getString("pwd"));
			member.setName(rs.getString("name"));
			member.setPhone(rs.getString("phone"));
			member.setAddress(rs.getString("address"));
			member.setEmail(rs.getString("email"));
			member.setPicture(rs.getString("picture"));

			member.setRegister(rs.getString("register"));
			member.setRegDate(rs.getDate("regDate"));
			member.setAuthority(rs.getString("authority"));
			member.setEnabled(rs.getInt("enabled"));

			memberList.add(member);
		}
		return memberList;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		JDBCDataSource dataSource = JDBCDataSource.getInstance();
		try {
			conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "select * from member where id = ?";
		ResultSet rs;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		MemberVO member = new MemberVO();

		if (rs.next()) {
			member.setId(rs.getString("id"));
			member.setPwd(rs.getString("pwd"));
			member.setName(rs.getString("name"));
			member.setPhone(rs.getString("phone"));
			member.setAddress(rs.getString("address"));
			member.setEmail(rs.getString("email"));
			member.setPicture(rs.getString("picture"));

			member.setRegister(rs.getString("register"));
			member.setRegDate(rs.getDate("regDate"));
			member.setAuthority(rs.getString("authority"));
			member.setEnabled(rs.getInt("enabled"));

		}
		return member;
	}

}
