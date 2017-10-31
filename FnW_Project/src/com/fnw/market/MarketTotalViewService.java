package com.fnw.market;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class MarketTotalViewService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("serviceView");
		ActionFoward actionFoward = new ActionFoward();

		Market_TotalDTO market_TotalDTO = null;
		Market_TotalDAO market_TotalDAO = new Market_TotalDAO();
		
		try {
			market_TotalDTO = market_TotalDAO.selectOne(Integer.parseInt(request.getParameter("num")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("marketTotal", market_TotalDTO);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/market/marketTotalDetails.jsp");


		return actionFoward;
	}

}
