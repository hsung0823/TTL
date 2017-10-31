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
		Market_TotalDAO market_TotalDAO = new Market_TotalDAO();
		
		ArrayList<Market_TotalDTO> list = new ArrayList<>();
		try {
			list = market_TotalDAO.selectList("joy");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("bookDeals", list);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/market/bookDealsList.jsp");
		
		return actionFoward;
	}

}
