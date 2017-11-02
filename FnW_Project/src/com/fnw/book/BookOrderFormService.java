package com.fnw.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class BookOrderFormService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();

		if(method.equals("GET")) {
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/book/bookOrderForm.jsp");
		} else {
			Book_OrderDAO book_OrderDAO = new Book_OrderDAO();
			Book_OrderDTO book_OrderDTO = new Book_OrderDTO();
			book_OrderDTO.setTitle(request.getParameter("title"));
			book_OrderDTO.setWriter(request.getParameter("writer"));
			book_OrderDTO.setCompany(request.getParameter("company"));
			book_OrderDTO.setPublish_date(request.getParameter("publish_date"));
			book_OrderDTO.setContents(request.getParameter("contents"));
			book_OrderDTO.setId(request.getParameter("id"));
			book_OrderDTO.setPrice(Integer.parseInt(request.getParameter("price")));
			book_OrderDTO.setLibrary(Integer.parseInt(request.getParameter("library")));

			int result = 0;
			String message = null;

			try {
				result = book_OrderDAO.insert(book_OrderDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(result > 0) {
				message = "등록 완료";
			}else {
				message = "등록 실패";
			}
			request.setAttribute("message", message);
			request.setAttribute("path", "../index.jsp");
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		}

		return actionFoward;
	}
}
