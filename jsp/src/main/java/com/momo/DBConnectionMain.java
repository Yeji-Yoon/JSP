package com.momo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionMain {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String id = "TESTUSER";
		String pw = "1234";
		
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		
		/*
		 * 1. 드라이버 로딩(해달 클래스가 있는지 없는지 확인)
		 * 		DB에 접근하기 위해 필요한 라이브러리가 있는지 확인
		 * 2. 커넥션 객체를 생성
		 * 
		 */
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 커넥션 생성
			con = DriverManager.getConnection(url,id,pw);
			//3. 쿼리 문장 준비
			String sql = "select emp_id,emp_name,emp_no from employee";
			
			//4.쿼리 문장 실행
			stmt = con.createStatement();
			
			//select 문장을 실행 할 경우 ResultSet을 반환함.
			//update,insert,delete의 경우 int 타입을 반환함. ->실행결과 몇건이 처리되었는지
		    rs = stmt.executeQuery(sql);
			rs.next(); //다음줄에 결과가 있어?(숫자나 이름으로 꺼내올수 있음)
			//숫자를 입력시 1부터 /숫자또는 결과 집합의 컬럼명
			System.out.println(rs.getString(1));
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("다라이버 로딩 실패 - 라이브러리를 찾을수 없습니다");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection 객체 생성 필패");
			e.printStackTrace();
		}finally {
			try {
			//null 확인 없으면 null poin exception
			//서버 환경을 위해 닫아줌.
			if(rs !=null) rs.close();
			if(stmt !=null) stmt.close();
			if(con !=null) con.close();
			}catch(Exception e) {
				System.out.println("자원 해제중 예외 사황이 발생 하였습니다.");
				e.printStackTrace();
			}
			
		}

	}

}
