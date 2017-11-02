package com.fnw.market;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class MarketDealDetailsListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		Market_Deal_DetailsDAO market_Deal_DetailsDAO = new Market_Deal_DetailsDAO();
		ArrayList<Market_Deal_DetailsDTO> list = new ArrayList<>();
		try {
			list = market_Deal_DetailsDAO.selectList(request.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("bookDeals", list);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/market/marketDealsList.jsp");
		
		return actionFoward;
	}

}
