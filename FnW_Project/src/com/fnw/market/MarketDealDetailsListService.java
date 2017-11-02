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
		
		String method = request.getMethod();
		
		int curPage=1;
		if(method.equals("GET")) {
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/market/marketDealsList.jsp");
		}else {
			try {
				curPage=Integer.parseInt(request.getParameter("curPage"));
			}catch(Exception e) {
				curPage=1;
			}
			
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			
			String p_date = year+"/"+month+"/"+day;
			if(p_date==null) {
				p_date="오늘";
			}
			
			int totalCount=0;
			String id = request.getParameter("id");
			Market_Deal_DetailsDAO market_Deal_DetailsDAO = new Market_Deal_DetailsDAO();
			try {
				totalCount = market_Deal_DetailsDAO.getTotalCount(p_date);
				PageMaker pageMaker = new PageMaker(curPage, totalCount);
				list = market_Deal_DetailsDAO.selectList(id,pageMaker.getMakeRow(), p_date);
				request.setAttribute("bookDeals", list);
				request.setAttribute("id", id);
				request.setAttribute("page", pageMaker.getMakePage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/market/marketDealsList.jsp");
		}
		return actionFoward;
	}

}
