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
		String search = request.getParameter("search");
		
		if(search==null) {
			search = "";
		}

		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberDTO> ar = null;
		try {
			ar = memberDAO.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list", ar);
		request.setAttribute("search", search);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/admin/admin_member_list.jsp");
		
		
		return actionFoward;
	}

	public void pagination(HttpServletRequest request, HttpServletResponse response, MemberDAO memberDAO) {
		int curPage = 1;
		curPage = Integer.parseInt(request.getParameter("curPage"));
		
		int totalCount = 0;
		
		int kind=1;
		try {
			kind = Integer.parseInt(request.getParameter("kind"));
		}catch (Exception e) {
			kind =1;
		}
		
		
				
		try {
			memberDAO.getTotalCount(kind);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
