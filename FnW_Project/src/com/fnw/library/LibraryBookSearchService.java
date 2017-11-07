package com.fnw.library;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.book.Book_TotalDTO;
import com.fnw.util.PageMaker;

public class LibraryBookSearchService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		ArrayList<Book_TotalDTO> ar = new ArrayList<>();
		
		String method = request.getMethod();

		if(method.equals("GET")){

			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/library/libraryBookSearch.jsp");

		}else {
			this.doPost(request);
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/library/libraryBookSearch.jsp");
		}

		return actionFoward;
	}


	private ArrayList<Book_TotalDTO> doPost(HttpServletRequest request) {
		ArrayList<Book_TotalDTO> ar = new ArrayList<>();
		int curPage=1;

		LibraryDAO libraryDAO = new LibraryDAO();
		
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
		int library=1;
		try {
			library = Integer.parseInt(request.getParameter("library"));
		} catch (Exception e) {
		}
		int totalCount=0;
		try {
			totalCount = libraryDAO.getTotalCount(kind, search);
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			ar = libraryDAO.selectList(pageMaker.getMakeRow(), kind, search, library);
			request.setAttribute("list", ar);
			request.setAttribute("page", pageMaker.getMakePage());
			request.setAttribute("kind", kind);
			request.setAttribute("search", search);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ar;
	}

}
