package com.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.BoardDao;
import com.board.dao.BoardDao2;

@WebServlet("/boardList2")
public class BoardListController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/boardList2");
		//BoardList조회
		BoardDao2 dao = new BoardDao2();
		
		//request영역에 저장 -> 화면까지 데이터를 유지하기 위해서
		request.setAttribute("list", dao.getList());
		
		//자원의 반납
		dao.close();
		//데이터 유지를 위해 화면 전환은 forward방식
		request.getRequestDispatcher("/board/boardlist.jsp").forward(request, response);
	}
	

}
