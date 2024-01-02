package com.momo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.momo.common.DBConnection;
import com.momo.dto.Job;
/**
 * Dao
 * 데이터 엑세스 객체(Data Access Object)
 * 
 * 데이터 베이스와의 상호작용을 관리하고 데이터 베이스에서 데이터를 읽고 쓰는데 사용
 * 
 * Dto(setter, getter만 존재)
 * 데이터 전송 객체 (Data TransFer Object)
 * 
 * 데이터를 전송하거나 전달하기 위해 사용되는 객체
 */
public class JobDao extends DBConnection{
	public JobDao(ServletContext application) {
		super(application);
	}
	/**
	 * job테이블의 내용을 조회후 리스트에 담아서 반환
	 * @return
	 */
	public List<Job> getList() {
		List<Job> list = new ArrayList<>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from job");
			while (rs.next()) {
				Job job = new Job();
				job.setJobCode(rs.getString(1));
				job.setJobName(rs.getString(2));
				
				list.add(job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}

	