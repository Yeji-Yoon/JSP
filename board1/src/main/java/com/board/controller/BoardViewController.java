package com.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.BoardDao;


@WebServlet("/boardView")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * 
	 * 사용자의 요청으로부터 게시글 번호를 추출합니다.
	 * 한건의 게시글에 대한 정보를 조회후 request에 담음.
	 * view.jsp로 화면을 전환함.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//쿼리스트링으로 전달된 파라메터를 추출
		String num = request.getParameter("num");
		
		//num에 해당하는 게시글 조회
		BoardDao dao = new BoardDao();
		request.setAttribute("boardDto", dao.getOne(num));
		dao.close();
		
		//view.jsp화면 저환
		request.getRequestDispatcher("/board/view.jsp").forward(request, response);
	}

}
