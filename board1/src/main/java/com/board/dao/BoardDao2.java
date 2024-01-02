package com.board.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.BoardDto;
import com.board.DBConnpool;

/**
 * DB에 접근해서 데이터에 대한 입력, 수정 ,삭제 조회
 * void = 반환 타입 없음
 */
public class BoardDao2 extends DBConnpool{
	
	public List<BoardDto> getList() {
		List<BoardDto> list = new ArrayList<>();
		String sql = "select b.*,m.name\r\n"
				+ "from board b, member m\r\n"
				+ "where b.id = m.id";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				BoardDto dto = new BoardDto();
				
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setId(rs.getString("id"));
				dto.setPostdate(rs.getString("postdate"));
				//join을 이용ㅎ서 다른 테이블의 데이터를 함께 조회 해올경우,
				//dto에 담기 위해 컬럼을 추가할수 있다.
				dto.setName(rs.getString("name"));
				
				//list에 담기
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("리스트 조회 중 오류가 발생하였습니다.");
			e.printStackTrace();
		}
		//리스트 반환
		return list;
	}
}
