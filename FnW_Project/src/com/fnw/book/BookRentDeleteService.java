package com.fnw.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.member.MemberDTO;

public class BookRentDeleteService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {

		ActionFoward actionFoward = new ActionFoward();
		Book_Rent_DetailsDAO book_Rent_DetailsDAO = new Book_Rent_DetailsDAO();
		int result = 0;
		try {
			result = book_Rent_DetailsDAO.delete(Integer.parseInt(request.getParameter("num")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String id = ((MemberDTO)request.getSession().getAttribute("member")).getId();
		if(result>0) {
			request.setAttribute("message", "삭제 완료");
			request.setAttribute("path", "./bookRentList.book?curPage=1&id="+id);
		}else {
			request.setAttribute("message", "삭제 실패");
			request.setAttribute("path", "./bookRentList.book?curPage=1&id="+id);
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/result.jsp");

		return actionFoward;
	}
}