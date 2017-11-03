package com.fnw.seat;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.member.MemberDTO;
import com.fnw.util.PageMaker;

public class SeatDetailsListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		ArrayList<Seat_DetailsDTO> list = new ArrayList<>();

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
		Seat_DetailsDAO seat_DetailsDAO = new Seat_DetailsDAO();
		
		try {
			totalCount = seat_DetailsDAO.getTotalCount(p_date);
			if(totalCount==0) {
				totalCount=1;
			}
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			list = seat_DetailsDAO.selectList(id,pageMaker.getMakeRow(), p_date);
			request.setAttribute("seatList", list);
			request.setAttribute("id", id);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			request.setAttribute("page", pageMaker.getMakePage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/seat/seatTotalList.jsp");
		return actionFoward;
	}

}
