package com.fnw.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class MemberUpdatePwCheckService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = null;
		
		if(method.equals("GET")) {
			memberDTO = memberDAO.selectOne();
			request.setAttribute("member", memberDTO);
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberUpdatePwCheck.jsp");
		}else {
			
		}
		return actionFoward;
	}

}
