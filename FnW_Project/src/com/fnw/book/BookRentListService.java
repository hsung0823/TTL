package com.fnw.book;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.util.PageMaker;

public class BookRentListService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		Book_Rent_DetailsDAO book_Rent_DetailsDAO = new Book_Rent_DetailsDAO();
		ArrayList<Book_Rent_DetailsDTO> list = new ArrayList<>();
		int curPage = 1;
		
		try {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		} catch (Exception e) {
			curPage=1;
		}
		
		String kind = request.getParameter("kind");
		if(kind==null) {
			kind="title";
		}
		String search = request.getParameter("search");
		if(search==null) {
			search="";
		}
		
		int totalCount = 0;
		String id = request.getParameter("id");
		try {
			totalCount = book_Rent_DetailsDAO.getTotalCount(kind, search);
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			list = book_Rent_DetailsDAO.selectList(id,pageMaker.getMakeRow(),kind,search);
			request.setAttribute("bookRentList", list);
			request.setAttribute("id", id);
			request.setAttribute("page", pageMaker.getMakePage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/book/bookRentList.jsp");
		
		return actionFoward;
	}
}