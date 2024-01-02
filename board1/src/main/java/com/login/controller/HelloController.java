package com.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.Common.DBConnPool;
import com.login.dao.HelloDao;

/**
 * 1. 사용자의 요청을 수집
 * 2. JSP 페이지 전환
 * @WebServlet("/url")
 * url 매핑 - url이 호출되면 서블릿이 실행 
 * 만약 url이 중복될 경우, 서버가 실행이 안될수 있다.
 */
@WebServlet("/hello")
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("str", "만나서 반갑습니다.");
		// 사용자의 요처을 처리후 화면으로 전환
		
		HelloDao dao = new HelloDao();
		//DB로부터 시간을 조회후 request영역에 저장
		request.setAttribute("time", dao.getTime());
		
		//사용 저장후 화면 전환
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
