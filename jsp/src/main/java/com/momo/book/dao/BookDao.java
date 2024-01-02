package com.momo.book.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.momo.common.DBConnPool;
import com.momo.dto.BoardDto;
import com.momo.dto.Criteria;
import com.momo.dto.MemberDto;
import com.momo.lib.dto.BookDto;
/**
 * DB에 접근하여 쿼릴르 질의 합니다.
 * @return 도서 목록
 */
public class BookDao extends DBConnPool{
	/**
	 * 도서목록을 조회 후 반환 합니다.
	 * @return 도서목록
	 */
	public List<BookDto> getList(Criteria cri) { 
		List <BookDto> list = new ArrayList<>();
		
		String where ="";
		
		if(!"".equals(cri.getSearchField()) 
				&& !"".equals(cri.getSearchField())) {
		where = " where "+cri.getSearchField()
						+ " like '%"+cri.getSearchWord()+"%'";
		
		}

		String sql = " select *\r\n"
					+ "    from book \r\n"
					+ " --최신 게시물을 먼저 조회하기 위해서 정렬함.\r\n"
					+ where
					+ "        order by no desc";
		
		try {
			//pageingQuery를 이용시 페이지 처릴를 위한 파라메터 세팅을 해주어야 합니다.
			sql = pageingQuery(sql);
			//쿼리 출력
			System.out.println("sql\n" +sql);
			
			pstmt = con.prepareStatement(sql);
			//페이지 파라메터 세팅
			pstmt.setInt(1, cri.getStartNum());
			pstmt.setInt(2, cri.getEndNum());
			
			//쿼리 실행
			rs = pstmt.executeQuery();
			
			//결과 집합으로 부터 도서의 정보를 가지고 와서 dto에 저장후 리스트에 담아줌.
			while (rs.next()) {
				 String no = rs.getString("no");
				 String title = rs.getString("title");
				 String author = rs.getString("author");
				 String rentYn = rs.getString("rentYn");
				 
				 BookDto dto = new BookDto(no,title,author,rentYn);
				 list.add(dto);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
		
		
	}
	/**
	 * 도서의 상세 정보를 조회후 반환함.
	 * @param no
	 * @return 도서 정보(BookDto)
	 */
	public BookDto view(String no) { 
		BookDto dto = new BookDto();
		String sql = "select*from book where no=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			//?의 갯수 만큼 파라메터를 설저함.
			pstmt.setString(1,no);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				//변수에 넣기 싫으면 dto에 직접 넣기
				dto.setNo(rs.getString("no"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setRentYn(rs.getString("RentYn"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return dto;
	}
	/**
	 * 도서의 총 건수를 조회함.
	 * @return
	 */
	public int getTotalCnt(Criteria cri) {
		int res = 0;
		String where = "";
		if(!"".equals(cri.getSearchField()) 
				&& !"".equals(cri.getSearchField())) {
		where = " where "+cri.getSearchField()
						+ " like '%"+cri.getSearchWord()+"%'";
		
		}
		String sql = "select count(*) from book"+where;
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
	
	/*
	 * 공통되는 부분이라서 DBConnPool에 넣음.
	String pageingQuery(String sql) {
		String before = "select * from(\r\n"
				+ "select t.*, ROWNUM rnum from (";
		
		String after = ")t\r\n"
				+ "    )\r\n"
				+ "where rnum between ? and ?";
		
		return before + sql + after;
	}
	*/
	/**
	 * 도서등록
	 * @param dto
	 * @return
	 */
	public int regBook(BookDto dto) {
		String sql = "insert into book (no, title, rentyn, author)\r\n"
				+ "        values (seq_book_no.nextval, ?, 'N', ?)";
		int res = 0;
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,dto.getTitle());
			pstmt.setString(2, dto.getAuthor());
			
			//slect 문장은 결과집합을 반환 : res = pstmt.executeQuery();
			//insert,delect,update의 반환 타입은 몇건이 처리되었는지 결과 - update사용
			res = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
