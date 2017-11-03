package com.fnw.market;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.member.MemberDTO;
import com.fnw.util.PageMaker;

public class MarketDealDetailsListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		ArrayList<Market_Deal_DetailsDTO> list = new ArrayList<>();
		String id = ((MemberDTO)request.getSession().getAttribute("member")).getId();

		int curPage=1;
		try {
			curPage=Integer.parseInt(request.getParameter("curPage"));
		}catch(Exception e) {
			curPage=1;
		}

		String year = request.getParameter("year");
		System.out.println("1:"+year);
		if(year == null) {
			year="2017";
		}
		System.out.println("2:"+year);
		String month = request.getParameter("month");
		if(month == null) {
			month="11";
		}		
		
		String day = request.getParameter("day");
		if(day == null) {
			day="2";
		}		
		
		String p_date = year+"/"+month+"/"+day;
		
		System.out.println(p_date);

		int totalCount=0;
		Market_Deal_DetailsDAO market_Deal_DetailsDAO = new Market_Deal_DetailsDAO();
		try {
			totalCount = market_Deal_DetailsDAO.getTotalCount(p_date);
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			list = market_Deal_DetailsDAO.selectList(id,pageMaker.getMakeRow(), p_date);
			request.setAttribute("bookDeals", list);
			request.setAttribute("id", id);
			request.setAttribute("year", year);
			request.setAttribute("page", pageMaker.getMakePage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/market/marketDealsList.jsp");

		return actionFoward;
	}

}
