package com.fnw.seat;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class SeatDetailsListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		Seat_DetailsDAO seat_DetailsDAO = new Seat_DetailsDAO();
		
		ArrayList<Seat_DetailsDTO> list = new ArrayList<>();
		try {
			list = seat_DetailsDAO.selectList(request.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("seatList", list);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/seat/seatTotalList.jsp");
		return actionFoward;
	}

}
