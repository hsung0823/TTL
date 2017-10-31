package com.fnw.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.util.PageMaker;

public class BookTotalSearchService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {

		ActionFoward actionFoward = new ActionFoward();
		Book_TotalDAO book_TotalDAO = new Book_TotalDAO();

		int curPage=1;
		try {
			curPage=Integer.parseInt(request.getParameter("curPage"));
		}catch (Exception e) {
			e.printStackTrace();
		}

		String kind = request.getParameter("kind");
		if(kind==null) {
			kind="title";
		}
		String search=request.getParameter("search");
		if(search==null) {
			search="";
		}

		int totalCount=0;
		try {
			totalCount = book_TotalDAO.getTotalCount(kind, search);
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			List<Book_TotalDTO> ar = book_TotalDAO.selectList(pageMaker.getMakeRow(), kind, search);
			request.setAttribute("list", ar);
			request.setAttribute("page", pageMaker.getMakePage());
			request.setAttribute("board", "notice");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/integration_portal/total_book_search.jsp");

		return actionFoward;
	}
}