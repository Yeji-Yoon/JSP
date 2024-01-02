package com.momo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.momo.common.DBConnection;
import com.momo.dto.DeptDto;
import com.momo.dto.EmpDto;
/**
 * DAO : DB로부터 데이터ㅢ CRUD작업을 처리하는 객체
 * 
 */
public class DeptDao extends DBConnection {
	//생성자룰 통해서 Connection객체를 생성후 멤버 변수 con에 저장
	public DeptDao (ServletContext application) {
		//application으로부터 데이터 베이스접속 섲보를 꺼내
		super(application);
	}
	
	public List<DeptDto> getList() {
		List<DeptDto> list = new ArrayList<>();
		String sql = "SELECT D.DEPT_ID, D.DEPT_TITLE, L.LOCAL_NAME "
				+ "FROM DEPARTMENT D, LOCATION L"
				+ "WHERE D.LOCATION_ID = L.LOCAL_CODE";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				//system.out print();
				//콘솔에 출력하던 데이터를 화면에 출력하기 위해서 리스트에 저장후 반환함
				DeptDto dto = new DeptDto();
				dto.setDept_id(rs.getString("dept_id"));
				dto.setDept_title(rs.getString("dept_title"));
				dto.setLocal_code(rs.getString("local_code"));
				dto.setLocal_name(rs.getString("local_name"));
				dto.setLocation_id(rs.getString("location_id"));
				dto.setNational_code(rs.getString("national_code"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException 예외 사항 발생");
			e.printStackTrace();
		}
		return list;
	}
}
