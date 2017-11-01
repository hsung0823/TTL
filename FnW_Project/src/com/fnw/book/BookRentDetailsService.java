package com.fnw.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class BookRentDetailsService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {

		ActionFoward actionFoward = new ActionFoward();
		Book_Rent_DetailsDAO book_Rent_DetailsDAO = new Book_Rent_DetailsDAO();
		Book_Rent_DetailsDTO book_Rent_DetailsDTO = null;
		
		try {
			book_Rent_DetailsDTO = book_Rent_DetailsDAO.selectOne(Integer.parseInt(request.getParameter("num")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("bookRentDTO", book_Rent_DetailsDTO);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/book/bookRentDetails.jsp");
		return actionFoward;
	}
}