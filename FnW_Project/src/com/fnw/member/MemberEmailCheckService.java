package com.fnw.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.util.EmailDAO;

public class MemberEmailCheckService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		String email = request.getParameter("email");
		if(method.equals("GET")) {
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberJoinEmail.jsp");
			
		}else {
			
			EmailDAO emailDAO = new EmailDAO();
			emailDAO.send(request, email);
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberEmailCheck.jsp");
			
		}

		
		return actionFoward;
	}

}
