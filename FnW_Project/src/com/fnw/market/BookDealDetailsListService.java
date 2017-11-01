package com.fnw.market;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class BookDealDetailsListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		Book_Deal_DetailsDAO book_Deal_DetailsDAO = new Book_Deal_DetailsDAO();
		ArrayList<Book_Deal_DetailsDTO> list = new ArrayList<>();
		try {
			list = book_Deal_DetailsDAO.selectList("joy");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("bookDeals", list);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/market/bookDealsList.jsp");
		
		return actionFoward;
	}

}
