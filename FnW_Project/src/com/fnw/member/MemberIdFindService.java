package com.fnw.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class MemberIdFindService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		
		if(method.equals("GET")) {
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberIdFind.jsp");
		}else {
			MemberDAO memberDAO = new MemberDAO();
			MemberDTO memberDTO = null;
			try {
				memberDTO = memberDAO.IdFind(request.getParameter("name"), request.getParameter("email"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String message=null;
			if(memberDTO !=null) {
				message="아이디 찾기 성공"+memberDTO.getId()+"입니다.";
				request.getSession().setAttribute("member", memberDTO);
				request.setAttribute("message", message);
				request.setAttribute("path", "../index.jsp");
			}else {
				message="아이디 찾기 실패";
				request.setAttribute("message", message);
				request.setAttribute("path", "./memberJoin.member");
			}
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		}
		
		return actionFoward;
	}

}
