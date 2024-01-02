package com.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao extends DBConnpool{
	/**
	 * DB로부터 게시글 1건에 대한 상세 정보를 조회후 반환
	 */
	public BoardDto getOne(String num) {
		BoardDto dto = new BoardDto();
		String sql = "select * from board \r\n"
				+ "where num = ?";
		//?를 이용한 인파라메터를 사용할수 있다.
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setPostdate(rs.getString("postdate"));
				dto.setVisitcount(rs.getString("visitcount"));
				dto.setName(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return dto;
	}
	/**
	 * DB로부터 리스트를 조회 후 반환
	 */
	public List<BoardDto> getList() {
		List<BoardDto> list = new ArrayList<>();
		// 쿼리 정의
		String sql = "select *from board";
		//인파라메터를 설정할수 있으므로 쿼리 실행전 sql문장을 세팅한다.
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//다음 행이 있는지 확인
			while(rs.next()) {
				//dto에 담아서 리스트에 담아서(여러행이므로) 반환함.
				BoardDto dto = new BoardDto();
				
				dto.setNum(rs.getString("num"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setPostdate(rs.getString("postdate"));
				dto.setVisitcount(rs.getString("visitcount"));
				
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
