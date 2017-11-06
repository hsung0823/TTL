package com.fnw.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.member.MemberDTO;

public class BookOrderWishDeleteService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		Book_Buy_WishDAO book_Buy_WishDAO = new Book_Buy_WishDAO();
		String method = request.getMethod();
		
		if(method.equals("GET")) {
			int result = 0;
			try {
				result = book_Buy_WishDAO.delete(Integer.parseInt(request.getParameter("num")));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String id = ((MemberDTO)request.getSession().getAttribute("member")).getId();
			if(result>0) {
				request.setAttribute("message", "삭제 완료");
				request.setAttribute("path", "./bookOrderWishList.book?curPage=1&id="+id);
			}else {
				request.setAttribute("message", "삭제 실패");
				request.setAttribute("path", "./bookOrderWishList.book?curPage=1&id="+id);
			}
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");

		}else {
			String[] param = request.getParameterValues("Pcheck");
			int result2 = 0;
			for(int i=0;i<param.length;i++) {
				try {
					result2 = book_Buy_WishDAO.delete(Integer.parseInt(param[i]));
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String id = ((MemberDTO)request.getSession().getAttribute("member")).getId();
				if(result2>0) {
					request.setAttribute("message", "삭제 완료");
					request.setAttribute("path", "./bookOrderWishList.book?curPage=1&id="+id);
				}else {
					request.setAttribute("message", "삭제 실패");
					request.setAttribute("path", "./bookOrderWishList.book?curPage=1&id="+id);
				}
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/common/result.jsp");
			}
		}
		return actionFoward;
	}
}