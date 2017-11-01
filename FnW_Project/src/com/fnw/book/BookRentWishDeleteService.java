package com.fnw.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class BookRentWishDeleteService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		Book_Rent_WishDAO book_Rent_WishDAO = new Book_Rent_WishDAO();
		int result = 0;
		try {
			result = book_Rent_WishDAO.delete(Integer.parseInt(request.getParameter("num")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result>0) {
			request.setAttribute("message", "삭제 완료");
			request.setAttribute("path", "./bookRentWishList.book");
		}else {
			request.setAttribute("message", "삭제 실패");
			request.setAttribute("path", "./bookRentWishList.book");
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/result.jsp");

		return actionFoward;
	}
}