package com.fnw.book;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class BookOrderListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		Book_OrderDAO book_OrderDAO = new Book_OrderDAO();
		ArrayList<Book_OrderDTO> list = new ArrayList<>();
		try {
			list = book_OrderDAO.selectList(request.getParameter("id"));
			request.setAttribute("bookOrderList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/book/bookOrderList.jsp");
		return actionFoward;
	}
}