package com.fnw.book;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
/*import com.fnw.book.Book_Buy_WishDAO;*/

public class BookRentWishListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		Book_Rent_WishDAO book_Rent_WishDAO = new Book_Rent_WishDAO();
		ArrayList<Book_Rent_WishDTO> list = new ArrayList<>();
		try {
			list = book_Rent_WishDAO.selectList(request.getParameter("id"));
			request.setAttribute("bookRentWishList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/book/bookRentWishList.jsp");
		return actionFoward;
	}
}