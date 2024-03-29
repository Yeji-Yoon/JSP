package com.momo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.momo.common.DBConnPool;
import com.momo.dto.BoardDto;
import com.momo.dto.Criteria;
//connectionpool : 매번 접속하면 부하가 걸림. 톰켓에서 제공해주는 기능을 사용하여 커넥션 객체를 미리 생성해놓고 사용
//	main메서드 사용이 불가능, 서버가 실행되어야 사용이 가능. 
//	만약 main메서드를 이용해서 테스트를 하고 싶다면 상솝받는 객체를 DBConnection으로 변경
//connection : 입력 수정 삭제만 가능
public class BoardDao extends DBConnPool{
//	public int insertBoard(BoardDto dto) {
//		
//	}
	public int deleteBoard(String num) {
		int res = 0;
		String sql = "delete from board where num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
		
	}
	
	/**
	 * 
	 * 게시글의 조회수를 1증가 시켜줍니다.
	 * insert, update, delet의 반환 타입은 int(몇건이 처리 되었는지 반환)
	 * 반환 타입은 int로 설정
	 */
	public int visitcountUp(String num) { 
		int res = 0;
		String sql = "update  board\r\n"
				+ "set      visitcount = visitcount+1\r\n"
				+ "where   num = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
				
			res = pstmt.executeUpdate();
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 한건의 게시글을 조회후 반납함
	 * @return
	 */
	public BoardDto getOne(String num) {
		BoardDto dto = null;
		String sql = "select * \r\n"
				+ "from board\r\n"
				+ "where num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDto();
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setNum(rs.getString("num"));
				dto.setPostdate(rs.getString("postdate"));
				dto.setTitle(rs.getString("title"));
				dto.setVisitcount(rs.getString("visitcount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	/**
	 * 게시글 목록을 반환함.
	 * @return List<BoardDto>
	 */
	public List<BoardDto> getList(Criteria cri) {
		List<BoardDto> list = new ArrayList<>();
		
		try {
			String where = "";
			//검색어와 검색 필드에 값이 들어 있다면 조건 문장을 생성함.
			if(!"".equals(cri.getSearchField())
					&& !"".equals(cri.getSearchWord())) {
				where = "where " + cri.getSearchField()
								+"like '%" + cri.getSearchWord() + "%'";
			}
			System.out.println("where : "+ where);
			pstmt = con.prepareStatement(" select *\r\n"
				+ " from (\r\n"
				+ "    select rownum rnum, b.*\r\n"
				+ "    from (\r\n"
				
				+ "            select *\r\n"
				+ "            from board b\r\n"
				+ "            --최신순으로 정렬\r\n"
				
				+ where 
				
				+ "            order by num desc\r\n"
				
				+ "        )b\r\n"
				+ "    )\r\n"
				+ " where rnum between ? and ?");
		
		 
			//시작 번호 = 끝번호- (페이지당 게시물수 -1)
			pstmt.setInt(1, cri.getStartNum());
			//끝번호 = 페이지 번호 * 페이지당 게시물수 
			pstmt.setInt(2, cri.getEndNum());
			
			rs = pstmt.executeQuery();
			
			System.out.println("pstmt" + pstmt);
			
			while(rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setNum(rs.getString("num"));
				dto.setPostdate(rs.getString("postDate"));
				dto.setTitle(rs.getString("title"));
				dto.setVisitcount(rs.getString("visitcount"));
			list.add(dto);
			}
			System.out.println("=========" + list);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*
		try {
			pstmt = con.prepareStatement("select * from board");
			rs = pstmt.executeQuery();
		*/
				
		return list;
	}
	/**
	 * 게시글의 총 건수를 조회후 반환
	 * -집계함수를 이용하여 게시글의 총건수를 구해봅시다.
	 * @return 게시글의 총 건수
	 */
	public int getTotalCnt(Criteria cri) {
		int res = 0;
		
		String where = "";
		//검색어와 검색 필드에 값이 들어 있다면 조건 문장을 생성함.
		if(!"".equals(cri.getSearchField())
				&& !"".equals(cri.getSearchWord())) {
			where = "where " + cri.getSearchField() 
			+ " like '%" + cri.getSearchWord() + "%'";
		}
		String sql = "select count(*) from board" + where;
		System.out.println("sql : " + sql);
		try {
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return res;
	}
	
}
