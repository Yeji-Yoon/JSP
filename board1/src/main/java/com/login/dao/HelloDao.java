package com.login.dao;

import java.sql.SQLException;

import com.login.Common.DBConnPool;

public class HelloDao extends DBConnPool {
	/**
	 * DB로 부터 현재 시간을 조회후 반환함.
	 * @return
	 */
	public String getTime() {
		String time = "";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select sysdate from dual");
			
			if(rs.next()) {
				//변수에 담아서 반환함.
				time = rs.getString(1);
				//System.out.println(rs.getString(1));
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return time;		
	}
}