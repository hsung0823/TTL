package com.fnw.seat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class SeatInfoService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method=request.getMethod();
		int seat_num = 1;
		int state =1;
		int library =1;
		String id = request.getParameter("id");
		try {
			seat_num = Integer.parseInt(request.getParameter("seat_num"));
			state = Integer.parseInt(request.getParameter("state"));
			library = Integer.parseInt(request.getParameter("library"));
		}catch (Exception e) {
		}
		
		if(method.equals("GET")) {
			
			if(state==0) {
				request.setAttribute("message", "이미 사용중인 자리 입니다");
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/common/resultClose.jsp");
			}else {
				SeatDAO seatDAO = new SeatDAO();
				SeatDTO seatDTO = null;
				try {
					seatDTO = seatDAO.selectOne(library, seat_num);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(seatDTO.equals(null)) {
					request.setAttribute("message", "없는 좌석이나 도서관입니다");
					actionFoward.setCheck(true);
					actionFoward.setPath("../WEB-INF/view/common/resultClose.jsp");
				}else {
					request.getSession().setAttribute("seat", seatDTO);
					actionFoward.setCheck(true);
					actionFoward.setPath("../WEB-INF/view/seat/seatInfo.jsp");
				}
			}
		
		
		}else {
			SeatDAO seatDAO = new SeatDAO();
			SeatDTO seatDTO = new SeatDTO();
			seatDTO.setId(id);
			seatDTO.setSeat_num(seat_num);
			int result=0;
			try {
				result = seatDAO.updateRent(seatDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String message="예약 실패";
			if(result>0) {
				message= seat_num + "번 자리 예약 성공";
			}
			request.setAttribute("message", message);
			request.setAttribute("path", "./seatList.seat");
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");
			
		}
		
		
		return actionFoward;
	}

}
