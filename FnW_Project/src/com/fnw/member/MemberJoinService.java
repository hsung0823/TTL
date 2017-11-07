package com.fnw.member;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class MemberJoinService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		
		if(method.equals("GET")){
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberJoin.jsp");
			
		}else {
			
			int result = this.doPost(request);
			
			String message=null;
			
			if(result>0) {
				message="join 성공";
				actionFoward.setCheck(false);
				actionFoward.setPath("../index.jsp");
				
			}else {
				message="join 실패";
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/member/memberJoin.jsp");
			}
			
		}
		
		return actionFoward;
	}

	private int doPost(HttpServletRequest request) {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(request.getParameter("id"));
		memberDTO.setPw(request.getParameter("pw"));
		memberDTO.setName(request.getParameter("name"));
		memberDTO.setBirth(Date.valueOf(request.getParameter("birth")));
		memberDTO.setGender(request.getParameter("gender"));
		memberDTO.setAddr(request.getParameter("addr"));
		memberDTO.setPhone(request.getParameter("phone"));
		memberDTO.setEmail(request.getParameter("email"));
		/*memberDTO.setLocation(request.getParameter("location"));*/
		int result =0;
		try {
			result = memberDAO.insert(memberDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
