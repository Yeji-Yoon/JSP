package com.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 * 톰켓으로부터 제공받는 기능이므로 서버를 싱행후 테스트 할수 있다.
 * -> main 메소드를 이용한 실행이 불가능 하다.
 */
public class DBConnpool {
	
	//DB에 접근하기 위해 필요한 데이터->리소스에 정의 
	//DB에 접근하여 쿼릴를 질의 하기 위해 필요한 객체
	//접근 제한자를 주지 않는 경우, 같은 패키지 내부에서만 접근이 가능
	
	public Connection con;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	public DBConnpool() {
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			con = ds.getConnection();
					
		} catch (NamingException e) {
			System.out.println("NamingException - jdbc/myoracle를 찾을수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 자원 반납
	 */
	public void close() {
		try {
			if(rs!= null) rs.close();
			if(pstmt != null) pstmt.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
		}catch (Exception e) {
			System.out.println("자원 반납 실패");
			e.printStackTrace();
		}
		
	}
}
