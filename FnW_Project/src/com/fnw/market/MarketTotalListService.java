package com.fnw.market;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.member.MemberDAO;
import com.fnw.util.PageMaker;

public class MarketTotalListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		int curPage = 1;
		try {
			curPage=Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
		}
		int totalCount =0;
		Market_TotalDAO market_TotalDAO = new Market_TotalDAO();
		ArrayList<Market_TotalDTO> ar = new ArrayList<>();
		
		try {
			totalCount = market_TotalDAO.getTotalCount();
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			ar = market_TotalDAO.selectList(pageMaker.getMakeRow());
			request.setAttribute("list", ar);
			request.setAttribute("page", pageMaker.getMakePage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/market/marketTotalList.jsp");
		return actionFoward;
	}

}
