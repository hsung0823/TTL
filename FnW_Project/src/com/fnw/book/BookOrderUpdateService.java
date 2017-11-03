package com.fnw.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class BookOrderUpdateService implements Action {
	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		String method = request.getMethod();
		Book_OrderDAO book_OrderDAO = new Book_OrderDAO();
		Book_OrderDTO book_OrderDTO = null;
		int result = 0;
		
		if(method.equals("GET")) {
			try {
				book_OrderDTO = book_OrderDAO.selectOne(Integer.parseInt(request.getParameter("num")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("bookorder", book_OrderDTO);
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/book/bookUpdate.jsp");
		}else {
			try {
				book_OrderDTO = new Book_OrderDTO();
				book_OrderDTO.setNum(Integer.parseInt(request.getParameter("num")));
				book_OrderDTO.setTitle(request.getParameter("title"));
				book_OrderDTO.setWriter(request.getParameter("writer"));
				book_OrderDTO.setCompany(request.getParameter("company"));
				book_OrderDTO.setPublish_date(request.getParameter("publish_date"));
				book_OrderDTO.setContents(request.getParameter("contents"));
				book_OrderDTO.setPrice(Integer.parseInt(request.getParameter("price")));
				book_OrderDTO.setLibrary(Integer.parseInt(request.getParameter("library")));
				result = book_OrderDAO.update(book_OrderDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if(result>0) {
				request.setAttribute("message", "수정 성공");
				request.setAttribute("path", "../index.jsp");
			}else{
				request.setAttribute("message", "수정 실패");
				request.setAttribute("path", "../index.jsp");
			}
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		}
		return actionFoward;
	}
}