package com.fnw.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.library.LibraryDAO;

public class BookRentService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		LibraryDAO libraryDAO = new LibraryDAO();
		int num = Integer.parseInt(request.getParameter("num"));
		String rent_id = request.getParameter("rent_id");
		int result = 0;
		
		try {
			result = libraryDAO.bookRent(num, rent_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(result>0) {
			request.setAttribute("message", "대여 완료");
			request.setAttribute("path", "../libraryBookSearch.library");
		}else {
			request.setAttribute("message", "대여 실패");
			request.setAttribute("path", "../libraryBookSearch.library");
		}

		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		
		return actionFoward;
	}
	
}
