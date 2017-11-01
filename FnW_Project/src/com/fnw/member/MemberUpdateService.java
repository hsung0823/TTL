package com.fnw.member;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class MemberUpdateService implements Action {

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
			actionFoward.setPath("../WEB-INF/view/member/memberUpdate.jsp");
		}else {
			memberDTO = new MemberDTO();
			memberDTO.setPw(request.getParameter("pw"));
			memberDTO.setAddr(request.getParameter("addr"));
			memberDTO.setBirth(Date.valueOf(request.getParameter("birth")));
			memberDTO.setEmail(request.getParameter("email"));
			memberDTO.setLibrary(Integer.parseInt(request.getParameter("library")));
			memberDTO.setPhone(request.getParameter("phone"));
			memberDTO.setId(request.getParameter("id"));
			try {
				result = memberDAO.update(memberDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(result>0) {
				request.setAttribute("message", "수정 완료");
				request.setAttribute("path", "./memberUpdatePwCheck.member");
			}else {
				request.setAttribute("message", "수정 실패");
				request.setAttribute("path", "./memberUpdatePwCheck.member");
			}
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		}
		
		return actionFoward;
	}

}
