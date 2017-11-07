package com.fnw.market;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.market.Market_OrderDTO;
import com.fnw.market.Market_OrderDAO;
import com.fnw.util.PageMaker;

public class MarketApplicationListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		Market_OrderDAO market_OrderDAO = new Market_OrderDAO();
		
		int curPage=1;
		try {
			curPage=Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		String kind = request.getParameter("kind");
		if(kind==null) {
			kind="title";
		}
		String search=request.getParameter("search");
		if(search==null) {
			search="";
		}
		
		int totalCount=0;
		try {
			totalCount = market_OrderDAO.getTotalCount(kind, search);
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			List<Market_OrderDTO> ar=market_OrderDAO.selectList(pageMaker.getMakeRow(), kind, search);
			request.setAttribute("list", ar);
			request.setAttribute("page", pageMaker.getMakePage());
			request.setAttribute("market", "market");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/market/marketApplicationList.jsp");
		
		return actionFoward;
	
	}

}
