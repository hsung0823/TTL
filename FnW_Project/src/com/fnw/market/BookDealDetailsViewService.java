package com.fnw.market;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class BookDealDetailsViewService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();

		Book_Deal_DetailsDTO book_Deal_DetailsDTO = null;
		Book_Deal_DetailsDAO book_Deal_DetailsDAO = new Book_Deal_DetailsDAO();
		
		try {
			book_Deal_DetailsDTO = book_Deal_DetailsDAO.selectOne(Integer.parseInt(request.getParameter("num")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("bookDealsDetail", book_Deal_DetailsDTO);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/market/bookDealsDetails.jsp");


		return actionFoward;
	}

}
