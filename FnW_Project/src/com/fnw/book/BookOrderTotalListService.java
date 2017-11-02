package com.fnw.book;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.util.PageMaker;

public class BookOrderTotalListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		Book_OrderDAO book_OrderDAO = new Book_OrderDAO();
		ArrayList<Book_OrderDTO> list = new ArrayList<>();
		
		int curPage = 0;
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		} catch (Exception e) {
			curPage = 1;
		}
		
		String kind = request.getParameter("kind");
		if(kind==null) {
			kind="title";
		}
		String search = request.getParameter("search");
		if(search==null) {
			search="";
		}

		String id = request.getParameter("id");
		int totalCount = 0;

		try {
			totalCount = book_OrderDAO.getTotalCount(kind, search);
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			list = book_OrderDAO.selectList(id,pageMaker.getMakeRow(),kind,search);
			request.setAttribute("bookOrderTotalList", list);
			request.setAttribute("id", id);
			request.setAttribute("page", pageMaker.getMakePage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/book/bookOrderTotalList.jsp");
		
		return actionFoward;
	}
}