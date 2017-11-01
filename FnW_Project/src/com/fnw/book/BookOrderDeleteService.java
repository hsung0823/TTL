package com.fnw.book;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class BookOrderDeleteService implements Action {
	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		Book_OrderDAO book_OrderDAO = new Book_OrderDAO();
		int result = 0;
		try {
			result = book_OrderDAO.delete(Integer.parseInt(request.getParameter("num")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result>0) {
			request.setAttribute("message", "취소 성공");
			request.setAttribute("path", "../index.jsp");
		}else{
			request.setAttribute("message", "취소 실패");
			request.setAttribute("path", "../index.jsp");
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		return actionFoward;
	}
}