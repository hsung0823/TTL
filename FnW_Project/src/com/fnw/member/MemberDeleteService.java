package com.fnw.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class MemberDeleteService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		MemberDAO memberDAO = new MemberDAO();
		int result  = 0;
		try {
			result = memberDAO.delete(request.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result>0) {
			request.setAttribute("message", "탈퇴 완료");
		}else {
			request.setAttribute("message", "탈퇴 실패");
		}
		actionFoward.setCheck(false);
		actionFoward.setPath("./memberUpdatePwCheck.member");
		return actionFoward;
	}

}
