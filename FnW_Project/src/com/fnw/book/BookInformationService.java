package com.fnw.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class BookInformationService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();

		Book_TotalDAO book_TotalDAO = new Book_TotalDAO();
		Book_TotalDTO book_TotalDTO = new Book_TotalDTO();
		int num = Integer.parseInt(request.getParameter("num"));

		try {
			book_TotalDTO = book_TotalDAO.selectOne(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("book", book_TotalDTO);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/book/bookInformation.jsp");
		
		return actionFoward;
	}
}