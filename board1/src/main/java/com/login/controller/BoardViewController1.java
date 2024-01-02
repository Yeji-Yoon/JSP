package com.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.BoardDao;


@WebServlet("/view1")
public class BoardViewController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라메터 수집
		String num = request.getParameter("num");
		
		BoardDao dao = new BoardDao();
		//DB로부터 건의 게시글을 조회후 BoardDto로 반환
		dao.updateVisitCount(num);
		//게시글을 조회시 조회수를 증가 시켜줌.
		request.setAttribute("boardDto", dao.getOne(num));
		
		//자원 반환
		dao.close();
		request.getRequestDispatcher("/board/view1.jsp").forward(request, response);
	}
}
