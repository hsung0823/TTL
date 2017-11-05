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
			EmailDAO emailDAO = new EmailDAO();
			int result = emailDAO.send(request, email);
			
			if(result>0) {
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/member/memberEmailCheck.jsp");
			}else {
				request.setAttribute("message", "이메일 형식이 다릅니다");
				request.setAttribute("path", "#");
				
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/common/result.jsp");
			}
			
		}else {
			
			EmailDAO emailDAO = new EmailDAO();
			emailDAO.send(request, email);
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberEmailCheck.jsp");
			
		}

		
		return actionFoward;
	}

}
