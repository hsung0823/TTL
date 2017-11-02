package com.fnw.book;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.member.MemberDAO;
import com.fnw.member.MemberDTO;
import com.fnw.util.PageMaker;

public class BookTotalSearchService implements Action {
	
	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {

		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		ArrayList<Book_TotalDTO> ar = new ArrayList<>();

		int curPage=1;
		
		if(method.equals("GET")) {
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/book/bookTotalSearch.jsp");
		} else {
			Book_TotalDAO book_TotalDAO = new Book_TotalDAO();
			try {
				curPage=Integer.parseInt(request.getParameter("curPage"));
			}catch (Exception e) {
			}
	
			String kind = request.getParameter("kind");
			System.out.println("kind:"+kind);
				if(kind==null) {
					kind="title";
				}
			String search=request.getParameter("search");
			System.out.println("search:" +search);
				if(search==null) {
					search="";
				}

			int totalCount=0;
			try {
				totalCount = book_TotalDAO.getTotalCount(kind, search);
				PageMaker pageMaker = new PageMaker(curPage, totalCount);
				ar = book_TotalDAO.selectList(pageMaker.getMakeRow(), kind, search);
				request.setAttribute("list", ar);
				request.setAttribute("page", pageMaker.getMakePage());
				request.setAttribute("board", "notice");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/book/bookTotalSearch.jsp");
		}
		return actionFoward;
	}
}