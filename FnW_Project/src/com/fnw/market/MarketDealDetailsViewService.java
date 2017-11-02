package com.fnw.market;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class MarketDealDetailsViewService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();

		Market_Deal_DetailsDTO market_Deal_DetailsDTO = null;
		Market_Deal_DetailsDAO market_Deal_DetailsDAO = new Market_Deal_DetailsDAO();
		
		try {
			market_Deal_DetailsDTO = market_Deal_DetailsDAO.selectOne(Integer.parseInt(request.getParameter("num")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("bookDealsDetail", market_Deal_DetailsDTO);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/market/marketDealsDetails.jsp");


		return actionFoward;
	}

}
