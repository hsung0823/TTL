package com.fnw.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class MemberPwFindService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		
		if(method.equals("GET")) {
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberPwFind.jsp");
		}else {
			MemberDAO memberDAO = new MemberDAO();
			MemberDTO memberDTO = null;
			try {
				memberDTO = memberDAO.PwFind(request.getParameter("id"),request.getParameter("name"), request.getParameter("email"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String message=null;
			if(memberDTO !=null) {
				message="Pw 찾기 성공"+memberDTO.getPw()+"입니다.";
				request.getSession().setAttribute("member", memberDTO);
				request.setAttribute("message", message);
				request.setAttribute("path", "../index.jsp");
			}else {
				message="Pw 찾기 실패";
				request.setAttribute("message", message);
				request.setAttribute("path", "./memberJoin.member");
			}
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		}
		
		return actionFoward;
	}

}
