package com.momo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.momo.common.DBConnPool;
import com.momo.common.DBConnection;
import com.momo.dto.EmpDto;


/**
 * dao의 역할
 * 데이터 베이스에 접근해서 
 * 데이터 입력, 출력, 삭제, 조회 작업을 처리하는 객체
 * 
 * Dao ->mapper
 */

public class EmpDao extends DBConnPool {
	/**
	 * 생성자를 이용하여 Connection객체를 생성후 멤버 변수인 con에 저장함.
	 * @param application
	 */

//	public EmpDao(ServletContext application) {
//		super(application);
//}
	/**
	 * 데이터베이스로부터 사원의 목록을 조회하여 반환합니다.
	 * 조회된 데이터를 반환하기 위해서 리스트에 담아줌.
	 */
	public List<EmpDto> getList() {
		List<EmpDto> list = new ArrayList<>();
		try {
			stmt = con.createStatement();
			String sql = "select * from employee";
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				//system.out print();
				//콘솔에 출력하던 데이터를 화면에 출력하기 위해서 리스트에 저장후 반환함
				EmpDto dto = new EmpDto();
				dto.setEmp_id(rs.getString(1));
				dto.setEmp_name(rs.getString(2));
				dto.setEmp_no(rs.getString(3));
//				System.out.print(rs.getString(1));
//				System.out.print(rs.getString(2));
//				System.out.print(rs.getString(3));
//				System.out.println();
				list.add(dto);
			}
			
			//자원 반납
			close();
			
		} catch (SQLException e) {
			System.out.println("SQLException 예외 사항 발생");
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		//EmpDao empDao = new EmpDao();
		//empDao.getList();
	}

}