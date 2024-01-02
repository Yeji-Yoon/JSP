package com.momo.dao;

import java.sql.SQLException;

import com.momo.common.DBConnPool;
import com.momo.dto.MemberDto;

public class MemberDao extends DBConnPool{
	
	public int regMember(MemberDto dto) {
		int res =0;
		//쿼리문장에는 ;를 입력하지 않습니다.
		String sql = "insert into member (id, pass, name, regidate, email) \r\n"
				+ "            values (?, ?, ?, sysdate, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			//파라메터 세팅
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getPass());
			pstmt.setString(3,dto.getName());
			pstmt.setString(4,dto.getEmail());
			
			//쿼리 실행
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
		return res;
	}
	public MemberDto login(String id, String pw) {
		MemberDto memberDto = new MemberDto();
		String sql = "SELECT * FROM MEMBER\r\n"
					+ "WHERE ID = ?\r\n"
					+ "AND PASS = ?";
		//입력받은 사용자 정보를 데이터 베이스로부터 조화
		try {
			pstmt = con.prepareStatement(sql);
			//파라메터 세팅
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			
			//쿼리 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//로그인 성공
				memberDto.setId(rs.getString(1));
				memberDto.setName(rs.getString(2));
				memberDto.setRegidate(rs.getString(3));
				//사용자정보를 Dto에 담아서 반환
				return memberDto;
			}else {
				//로그인 실패
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		//사용자 정보를 MemberDto객체에 담아서 반혼
		//return memberDto;
	}
}
