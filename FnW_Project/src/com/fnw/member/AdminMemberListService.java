package com.fnw.member;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.util.PageMaker;

public class AdminMemberListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method=request.getMethod();
		int kind = 1;
		try {
			kind = Integer.parseInt(request.getParameter("kind"));
		}catch (Exception e) {
		}
		
		if(method.equals("GET")) {
			this.pagination(request, kind);
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/admin/admin_member_list.jsp");
			
		}else {
			
			this.pagination(request, kind);
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/admin/admin_member_list_ajax.jsp");
		}
		
		return actionFoward;
	}

	public void pagination(HttpServletRequest request, int kind) {
		int curPage = 1;
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		} catch (Exception e) {
			curPage=1;
		}
		MemberDAO memberDAO = new MemberDAO();
		int totalCount = 0;
		ArrayList<MemberDTO> ar = new ArrayList<>();
		try {
			totalCount = memberDAO.getTotalCount(kind);
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			
			ar = memberDAO.selectList(kind, pageMaker.getMakeRow());
			request.setAttribute("list", ar);
			request.setAttribute("page", pageMaker.getMakePage());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//pagination 끝
	
}
