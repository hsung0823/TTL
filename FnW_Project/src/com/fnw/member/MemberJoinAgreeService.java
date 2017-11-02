package com.fnw.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class MemberJoinAgreeService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		
		if(method.equals("GET")){
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberJoinAgree.jsp");
			
		}
		
		return actionFoward;
	}
	

}
