package com.fnw.seat;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class SeatListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		
		int library=1;
		try {
			library = Integer.parseInt(request.getParameter("library"));
		}catch (Exception e) {
		}
		
		if(method.equals("GET")) {
			SeatDAO seatDAO = new SeatDAO();
			ArrayList<SeatDTO> ar1 = new ArrayList<>();
			ArrayList<SeatDTO> ar2 = new ArrayList<>();
			ArrayList<SeatDTO> ar3 = new ArrayList<>();
			try {
				ar1 = seatDAO.selectList(1);
				ar2 = seatDAO.selectList(2);
				ar3 = seatDAO.selectList(3);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("seat1", ar1);
			request.setAttribute("seat2", ar2);
			request.setAttribute("seat3", ar3);
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/seat/seatList.jsp");
		}else {
			SeatDAO seatDAO = new SeatDAO();
			ArrayList<SeatDTO> ar = new ArrayList<>();
			try {
				ar = seatDAO.selectList(library);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("seat", ar);
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/seat/seatView.jsp");
		}
		
		
		return actionFoward;
	}

}
