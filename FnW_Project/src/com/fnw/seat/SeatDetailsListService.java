package com.fnw.seat;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.util.PageMaker;

public class SeatDetailsListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		ArrayList<Seat_DetailsDTO> list = new ArrayList<>();

		int curPage=1;
		try {
			curPage=Integer.parseInt(request.getParameter("curPage"));
		}catch(Exception e) {
			curPage=1;
		}
		
		String kind = request.getParameter("kind");
		if(kind==null) {
			kind="LIBRARY";
		}
		String search=request.getParameter("search");
		if(search==null) {
			search="1";
		}
		
		int totalCount=0;
		String id = request.getParameter("id");
		Seat_DetailsDAO seat_DetailsDAO = new Seat_DetailsDAO();
		
		try {
			totalCount = seat_DetailsDAO.getTotalCount("LIBRARY", "1");
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			list = seat_DetailsDAO.selectList(id,pageMaker.getMakeRow(), "LIBRARY", "1");
			request.setAttribute("seatList", list);
			request.setAttribute("id", id);
			request.setAttribute("page", pageMaker.getMakePage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/seat/seatTotalList.jsp");
		return actionFoward;
	}

}
