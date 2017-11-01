package com.fnw.book;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class BookOrderDetailsService implements Action {
	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		Book_OrderDTO book_OrderDTO = null;
		Book_OrderDAO book_OrderDAO = new Book_OrderDAO();
		
		try {
			book_OrderDTO = book_OrderDAO.selectOne(Integer.parseInt(request.getParameter("num")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("bookOrderDetails", book_OrderDTO);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/book/bookOrderDetails.jsp");
		return actionFoward;
	}
}