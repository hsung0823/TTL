package com.fnw.market;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.util.PageMaker;

public class MarketDealDetailsListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		ArrayList<Market_Deal_DetailsDTO> list = new ArrayList<>();
		
		int curPage=1;
		
		String kind = request.getParameter("kind");
		if(kind==null) {
			kind="title";
		}
		String search=request.getParameter("search");
		if(search==null) {
			search="";
		}
		int totalCount=0;
		String id = request.getParameter("id");
		Market_Deal_DetailsDAO market_Deal_DetailsDAO = new Market_Deal_DetailsDAO();
		try {
			curPage=Integer.parseInt(request.getParameter("curPage"));
			totalCount = market_Deal_DetailsDAO.getTotalCount(kind, search);
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			list = market_Deal_DetailsDAO.selectList(id,pageMaker.getMakeRow(), kind, search);
			request.setAttribute("bookDeals", list);
			request.setAttribute("page", pageMaker.getMakePage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/market/marketDealsList.jsp");

		return actionFoward;
	}

}
