package com.masai.utility;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DBUtil dbu= new DBUtil();
		
		Connection conn =DBUtil.provideConnection();
		
		System.out.println(conn);

	}

}
