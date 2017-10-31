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
		int result = 0;
		
		if(method.equals("GET")) {
			try {
				memberDTO = memberDAO.selectOne("joy");
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("member", memberDTO);
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberUpdatePwCheck.jsp");
		}else {
			try {
				memberDTO = memberDAO.selectOne(request.getParameter("id"));
				result = memberDAO.selectOne(request.getParameter("id"),request.getParameter("pw"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(result);
			if(result>0) {
				System.out.println("성공");
				request.setAttribute("member", memberDTO);
				actionFoward.setCheck(true);
				actionFoward.setPath("./memberUpdate.member");
			}
			else {
				System.out.println("실패");
				request.setAttribute("message", "비밀번호 다시 입력하세요.");
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/common/result.jsp");
			}
		}
		return actionFoward;
	}

}
