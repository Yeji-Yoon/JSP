package com.momo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.dao.JobDao;
import com.momo.dto.Job;

/**
 * 사용자가 /JobListController 경로를 요청하려면
 * 요청 URL에 매핑된 서블릿이 실행
 * 
 * 요청 전달된 메서드에 의해 실행될 메서드가 결정된다
 * -사용자가 지정하지 않은경우 get 방식
 * -링크를 클릭했을때, 주소창에서 직접 입력 했을때
 * 
 * get방식 요청에 대해서는 doGet메서드가 실행되고 
 * post방식 요청에 대해서는 doPost메서드가 실행된다.
 * 해당요청 방식이 구현되어 있지 않은 경우 오루가 발생한다.
 * 
 * 서블릿을 상속 받아서 만듬.
 * 
 * 서블릿이 아닌 java 파일을 실행 할 경우, 404오류 발생함.
 */
@WebServlet("/jobList")
public class JobListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JobListController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//jsp의 내장 객체 application = request.getServletContext()
		JobDao jobDao = new JobDao(request.getServletContext());
		List<Job> list = jobDao.getList();
		System.out.println("===============jobList");
		System.out.println(list);
		
		//화면에 출력하기 위해 request객체를 담아줌.
		request.setAttribute("list",list);
		//화면 전환
		request.getRequestDispatcher("jobList.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
