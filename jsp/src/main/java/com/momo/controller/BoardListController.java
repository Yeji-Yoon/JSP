package com.momo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.dao.BoardDao;
import com.momo.dto.BoardDto;
import com.momo.dto.Criteria;
import com.momo.dto.PageDto;

@WebServlet("/boardList")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("검색어"+request.getParameter("searchWord"));
//		System.out.println("검색필드"+request.getParameter("searchField"));
		
		
		//리스트를 조회하기 위한 파라메터 수집
		Criteria cri = new Criteria(request.getParameter("pageNo")
				,request.getParameter("amount")
				,request.getParameter("searchField")
				,request.getParameter("searchWord"));
		System.out.println(cri);
		//리스트 조회후 리쿼스트 영역에 저장
		BoardDao dao = new BoardDao();
		List<BoardDto> list = dao.getList(cri);
		request.setAttribute("list", list);
		
		//페이지 블럭을 생성하기 위해 필요한 정보를 저장
		//cri :요청 페이지 번호, 페이지당 게시물 수
		/*아래 dto에 담김
		request.setAttribute("cri", cri);
		//totalCnt : 총 게시물의 수
		request.setAttribute("totalCnt", dao.getTotalCnt());
		*/
		//페이지 블럭을 생성하기 위해 필요한 정보를 저장
		//조회 조건을 세팅하지않으면 조회되는 게시글의 건수와 페이지 블럭이 다르게 표시될수도 있다.
		int totalCnt = dao.getTotalCnt(cri);
		PageDto pageDto = new PageDto(totalCnt,cri);
		request.setAttribute("pageDto", pageDto);
		
		dao.close();
		
		
//		//페이지 조회에 필요한 정보를 수집합
//		//pageNo : 요청 페이지 번호
//		//amount : 페이지당 게시물의 수
//		int pageNo = 1;
//		int amount = 10;
//		try {
//		if(request.getParameter("pageNo") != null
//			&& !"".equals(request.getParameter("pageNo"))){
//			//숫자로 변환후 저장
//			pageNo = Integer.parseInt(request.getParameter("pageNo"));
//		}
//		if(request.getParameter("amount") != null
//				&& !"".equals(request.getParameter("amount"))){
//				//숫자로 변환후 저장
//			amount = Integer.parseInt(request.getParameter("amount"));
//			}
//		}catch(Exception e) {
//			System.out.println("파라메터 수집중에 예외사항이 발견되었다.");
//		}
//		
//		int endNum = pageNo *amount;
//		int startNum = endNum - (amount-1);
//		
		//페이지전환 forward방식으로 전환 하므로 request영역이 공유됨
		request.getRequestDispatcher("/06session/servletEx/board.jsp").forward(request,response);
	}

}
