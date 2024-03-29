package com.momo.lib.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.lib.dao.BookDao;


@WebServlet("/bookList")
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * 도서 목록을 조회 후 request영역에 저장함
	 * bookList.jsp로 forward
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao dao = new BookDao();
		request.setAttribute("list", dao.getList());
		dao.close();
		request.getRequestDispatcher("/lib/bookList.jsp").forward(request, response);
	}
}
