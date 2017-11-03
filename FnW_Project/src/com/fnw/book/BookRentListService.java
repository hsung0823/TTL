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
		
		String year = request.getParameter("year");
		if(year==null) {
			year="17";
		}
		String month = request.getParameter("month");
		if(month==null) {
			month="11";
		}
		String day =request.getParameter("day");
		if(day==null) {
			day="03";
		}
		String p_date = year+"/"+month+"/"+day;
		
		System.out.println(p_date);
		
		int totalCount = 0;
		String id = request.getParameter("id");
		try {
			totalCount = book_Rent_DetailsDAO.getTotalCount(p_date);
			if(totalCount==0) {
				totalCount=1;
			}
			PageMaker pageMaker = new PageMaker(curPage, totalCount);
			list = book_Rent_DetailsDAO.selectList(id,pageMaker.getMakeRow(),p_date);
			request.setAttribute("bookRentList", list);
			request.setAttribute("id", id);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			request.setAttribute("page", pageMaker.getMakePage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/book/bookRentList.jsp");
		
		return actionFoward;
	}
}