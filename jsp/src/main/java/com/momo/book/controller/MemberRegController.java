package com.momo.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.momo.dao.MemberDao;
import com.momo.dto.MemberDto;


@WebServlet("/book/regProcess")
public class MemberRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 주소표시줄에서 바로 호출하는 경우, 기본방식으로 요청이 되어지므로 
	 * 405오류가 발생할수 있음
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget요청");
		
		//한글깨짐처리
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.append("post방식으로 요청해주세요.");
	}
	/**
	 * 회원가입을 진행합니다.
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) 
					throws ServletException, IOException {
		
		//파라메터 수집
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		//dto를 생성
		MemberDto dto = new MemberDto(id,pw,name,"",email);
		System.out.println(dto);
		MemberDao dao = new MemberDao();
		
		//회원가입
		int res = dao.regMember(dto);
		
		//자원반남
		dao.close();
		
		//메시지 출력후 페이지 전환(성공 : 로그인 페이지로 이동, 실패 : 뒤로가기
		if(res>0) {
			//회원가입 성공
			request.setAttribute("msg", "회원가입 성공!! 로그인 후 이용해주세요.");
			request.setAttribute("url", "/06session/servletEx/loginForm.jsp");
		}else {
			//회원가입 실패 - 컬럼의 사이즈보다 입력값이 큰경우, 타입이 맞지 않은 경우 ->유효성검증으로 해결
			request.setAttribute("mag", "회원가입 실패!! errocode 관리자에게 문의해주세요");
		}
//		위로 한번에 퉁치기
//		dto.setId(id);
//		dto.setName(name);
//		dto.setEmail(email);
		
		//forward방식으로 페이지 전환  - request영역을 공유
		request.getRequestDispatcher("/book/msgBox.jsp").forward(request, response);
		
//		
//		if(dto != null) {
//			session.setAttribute("userId",dto.getId());
//			session.setAttribute("MemberDto",dto);

	}
}
 