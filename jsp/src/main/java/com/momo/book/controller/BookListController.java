package com.momo.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.book.dao.BookDao;
import com.momo.dto.Criteria;
import com.momo.dto.PageDto;
import com.momo.lib.dto.BookDto;

@WebServlet("/book/list")
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   /**
    * 도서 목록을 조회함.
    */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자의 요청 정보를 수집함.
		//Criteria : 검색 조건(=페이지 정보)을 수집
		Criteria cri = new Criteria(
				request.getParameter("pageNo") //요청 페이지 번호
				,request.getParameter("amount")//페이지당 보여줄 게시물의 수
				,request.getParameter("searchField")
				,request.getParameter("searchWord")
				);
		System.out.println(cri);
		// 도서 목록 조회gn request 영역에 담아줍니다.(생성->조회)
		BookDao dao = new BookDao();
		
		List<BookDto> list = dao.getList(cri);
		//페이지 블럭을 생성하기 위한 객체
		PageDto pageDto = new PageDto(dao.getTotalCnt(cri),cri);
		
		request.setAttribute("list", list);
		//request영역에 pageDto를 저장
		request.setAttribute("pageDto", pageDto);
		
		
		dao.close();
		//JSP화면으로 전환(forward 방식)
		request.getRequestDispatcher("/book/list1.jsp").forward(request, response);
	}

}
