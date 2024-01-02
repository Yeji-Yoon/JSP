package com.momo.book.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.book.dao.BookDao;
import com.momo.lib.dto.BookDto;


@WebServlet("/book/bookRegProcess")
public class BookRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//오류 날때를 대비해서 
    	response.getWriter().append("get방식 요청입니다.확인후 다시 요청해주세요").append(request.getContextPath());
    	//한글깨짐처리
    			response.setCharacterEncoding("UTF-8");
    			response.setContentType("text/html; charset=UTF-8");
  
	}
	/**
	 * 도서 등록후 메세지 처리
	 */
    protected void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException {
    	
		//파라메터를 수집후 bookDto를 생성함.
    	String title =request.getParameter("title");
		String author = request.getParameter("author");		
		String content = request.getParameter("content");	
		String imgFile = request.getParameter("imgFile");	
		BookDto dto = new BookDto("",title,author,"");
		
		//도서를 등록 처리합니다.
		BookDao dao = new BookDao();	
		int res = dao.regBook(dto);
		
		//입력성공
		if(res>0) {
			request.setAttribute("msg", "등록되었습니다.");
			request.setAttribute("url", "/book/list");
		//입력실패
		} else {
			request.setAttribute("msg", "등록중 예외가 발생하였습니다. \n 관리자에게 문의해주세요");
		}
		
		dao.close();
		//페이지 전환(도서등록 성공 : 목록페이지 이동, 실패 : 뒤로가기(뒤로갔을때 설정 값 남아있음)
		request.getRequestDispatcher("/book/msgBox.jsp").forward(request, response);
	}
	

}
