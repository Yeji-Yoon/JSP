package com.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.MemberDao;
import com.login.dto.MemberDto;

@WebServlet("/loginAction")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * 로그인 처리
	 * - 요청 데이터 확인
	 * 		id, pw가 일치하는 사용자가 있는지 확인후 
	 * 		사용자가 있으면 - 로그인 성공 -> 사용자 정보를 세션에 저장후 board.jsp페이지로 이동
	 * 		사용자가 없으면 - 로그인 실패 -> 'id,비밀번호를 확인해주세요'메세지를 띄우고 이전페이지로 이동
	 * - 요청 메서드에 따라 doGet,doPost메서드가 실행됨.
	 * 요청 방식(method) - 요청 방식을 지정하지 않으면 get 방식으로 호출
	 * 					- 요청 방식에 해당하는 메서드가 구현 되어 있지 않은 경우 405오류가 발생할수 있음.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청 데이터 수집 (id,pw)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		//2. 사용자 정보 조회(MemberDao.login(id,pw))
		//		MemberDto,MemberDao생성
		
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.login(id, pw);
		
		dao.close();
		//3. 화면 전환
		if(dto != null) {
			//로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("userId", dto.getId());
			session.setAttribute("memberDto", dto);
			
			//세션 영역에 로그인 정보를 저장 -> forward,redirect어느것으로 페이지를 전환해도 상관없음.
			//forward방식으로 페이지를 전환시 405 오류가 발생할수 있다.
			// /loginAction ->post
			// /list-> get
			//request.getRequestDispatcher("/board/board.jsp").forward(request, response);
			response.sendRedirect("/list");
			//서블릿을 요청시 주의사항
			//요청 받을 당시 방식(method)가 유지되므로 405오류가 발생할 소지가 있다.
			
		}else {
			//로그인 실패
			//서블릿의 한글 깨짐 처리 
//			response.setContentType("text/html;charset=UTF-8");
			request.setAttribute("msg", "아이디 비밀 번호를 확인해주세요");
			request.getRequestDispatcher("/msgbox.jsp").forward(request, response);
//			response.getWriter().append("<script>");
//			response.getWriter().append("alert('아이디 비밀번호를 확인해주세요');");
//			response.getWriter().append("history.back();");
//			response.getWriter().append("</script>");
//			//request.getRequestDispatcher("/login.jsp?isError=1").forward(request, response);
		}
		
		dao.close();
		
	}

}
