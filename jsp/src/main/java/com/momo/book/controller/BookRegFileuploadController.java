package com.momo.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.book.dao.BookDao;
import com.momo.book.service.FileUploadService;
import com.momo.lib.dto.BookDto;
import com.oreilly.servlet.MultipartRequest;

/**
 * 
 */
@WebServlet("/book/bookRegUploadProcess")
public class BookRegFileuploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse  response) throws ServletException, IOException {
		//첨부파일 저장
		FileUploadService fileService = new FileUploadService();
		MultipartRequest mr = fileService.fileUpload(request, "imgFile","book" );
		
//		FileUploadService로 대체
//		MultipartRequest mr = new MultipartRequest(request, "c:/upload", 1024*1000, "UTF-8");
//		//reg의 표지이미지 name
//		String fileName = mr.getFilesystemName("imgFile");
//		System.out.println(fileName);
		
		String title = mr.getParameter("title");
		String author = mr.getParameter("author");
		System.out.println(title+"/"+author);
		
		
	}

}
