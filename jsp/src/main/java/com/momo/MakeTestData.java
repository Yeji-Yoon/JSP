package com.momo;

import java.sql.SQLException;

import com.momo.common.DBConnection;
/**
 * JDBC를 활용한 테스트 데이터 생성
 * board테이블에 테스트 데이터를 생성함.
 */
public class MakeTestData extends DBConnection{
	/**
	 * board테이블에 데이터를 삽입
	 */
	public void insert() {
		//입력 쿼리
		String sql = "INSERT INTO BOARD columns(NUM, TITLE, CONTENT, ID, POSTDATE) \r\n "
                + " VALUES(SEQ_BOARD_NUM.nextval,'제목'||SEQ_BOARD_NUM.currval,'내용'||SEQ_BOARD_NUM.currval,'test', sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			
			//입력 실행
			int res = pstmt.executeUpdate();
			System.out.println(res + "건 입력되었습니다.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	public static void main(String[] args) {
		MakeTestData d = new MakeTestData();
		for(int i=0;i<100;i++) {
			d.insert();
		}
		//자원 반납
		d.close();
	}
}
