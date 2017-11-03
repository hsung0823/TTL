package com.fnw.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class MemberEmailOkService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		request.getSession().setAttribute("email", "ok");
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../index.jsp");
		
		
		return actionFoward;
	}

}
