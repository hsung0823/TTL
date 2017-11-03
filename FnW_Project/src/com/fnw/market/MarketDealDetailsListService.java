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
		if(year == null) {
			year="17";
		}
		String month = request.getParameter("month");
		if(month == null) {
			month="11";
		}		
		
		String day = request.getParameter("day");
		if(day == null) {
			day="03";
		}		
		String p_date = year+"/"+month+"/"+day;

		int totalCount=0;
		Market_Deal_DetailsDAO market_Deal_DetailsDAO = new Market_Deal_DetailsDAO();
		try {
			totalCount = market_Deal_DetailsDAO.getTotalCount(p_date);
			if(totalCount==0) {
				totalCount=1;
			}
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			list = market_Deal_DetailsDAO.selectList(id,pageMaker.getMakeRow(), p_date);
			request.setAttribute("bookDeals", list);
			request.setAttribute("id", id);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			request.setAttribute("page", pageMaker.getMakePage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/market/marketDealsList.jsp");

		return actionFoward;
	}

}
