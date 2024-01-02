package com.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.dao.BoardDao;
import com.login.dto.Criteria;
import com.login.dto.PageDto;

@WebServlet("/list")
public class BoardListController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * 게시글 목록을 조회
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//페이지 번호와 페이지당 게시물수를 설정후조회할 게시물의 시작번호와 끝번호를 알아냄
		Criteria cri = new Criteria(request.getParameter("pageNo"), request.getParameter("amount"));
		BoardDao dao = new BoardDao();
	    int total = dao.getTotalCnt();
	    PageDto pageDto = new PageDto(total, cri);

		/*
		int pageNo = 1;
		int amount = 10;
		
		//전달된 값이 있으면 변경 없으면 기본값
		if( request.getParameter("pageNo") != null 
				&& !"".equals(request.getParameter("pageNo"))) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if( request.getParameter("amount") != null 
				&& !"".equals(request.getParameter("amount"))) {
			pageNo = Integer.parseInt(request.getParameter("amount"));
		}
		System.out.println("pageNo = "+ pageNo);
		System.out.println("amount = "+ amount);
		
		//시작 번호화 끝번호를 계산
		int endNum = pageNo * amount;
		int startNum = endNum - (amount -1);
		*/
		
		request.setAttribute("list", dao.getList(cri.getStartNo(), cri.getEndNo()));
	    request.setAttribute("pageDto", pageDto);

		request.getRequestDispatcher("/board/board.jsp").forward(request, response);
	}

}
