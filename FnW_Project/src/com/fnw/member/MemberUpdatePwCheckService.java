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
		
		if(method.equals("GET")) {
			MemberDTO memberDTO = null;
			try {
				memberDTO = memberDAO.selectOne(request.getParameter("id"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("member", memberDTO);
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberUpdatePwCheck.jsp");
		}
		
		
		else {
			MemberDTO memberDTO = new MemberDTO();	
			
			try {
				memberDTO = memberDAO.selectOne(request.getParameter("id"),request.getParameter("pw"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(memberDTO!=null) {
				request.setAttribute("member", memberDTO);
				actionFoward.setCheck(false);
				actionFoward.setPath("./memberUpdate.member");
			}
			else {
				request.setAttribute("message", "비밀번호 다시 입력하세요.");
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/common/result.jsp");
			}
		}
		
		return actionFoward;
	}

}
