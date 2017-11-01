package com.fnw.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class AdminMemberListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberDTO> ar = null;
		try {
			ar = memberDAO.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list", ar);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/admin/admin_member_list.jsp");
		
		
		return actionFoward;
	}

}
