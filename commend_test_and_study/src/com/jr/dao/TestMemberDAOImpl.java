package com.jr.dao;

import com.jr.datasource.MybastisSqlSessionFactory;

public class TestMemberDAOImpl {

	public static void main(String[] args) {
		MybastisSqlSessionFactory m = new MybastisSqlSessionFactory();
		m.getConfiguration();
	}

}
