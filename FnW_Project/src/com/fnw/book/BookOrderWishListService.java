package com.fnw.book;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.book.Book_Buy_WishDAO;

public class BookOrderWishListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		Book_Buy_WishDAO book_Buy_WishDAO = new Book_Buy_WishDAO();
		ArrayList<Book_Buy_WishDTO> list = new ArrayList<>();
		try {
			list = book_Buy_WishDAO.selectList(request.getParameter("id"));
			request.setAttribute("bookOrderWishList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/book/bookOrderWishList.jsp");
		return actionFoward;
	}
}