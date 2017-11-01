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
			MemberDTO memberDTO =(MemberDTO)request.getSession().getAttribute("member");
			String id = memberDTO.getId();
			
			if(id.equals(request.getParameter("id"))) { // 본인이면
				request.setAttribute("path", "../index.jsp");
				request.getSession().invalidate();
			}else {//본인이 아니면
				request.setAttribute("path", "./memberList.member");
			}
			
		}else {
			request.setAttribute("message", "탈퇴 실패");
			request.setAttribute("path", "../index.jsp");
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		return actionFoward;
	}

}
