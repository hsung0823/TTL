package com.fnw.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.market.Market_Deal_DetailsDAO;
import com.fnw.member.MemberDTO;

public class QnaDeleteService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		QnaDAO qnaDAO = new QnaDAO();
		
		int result = 0;
		try {
			result = qnaDAO.delete(Integer.parseInt(request.getParameter("num")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result>0) {
			request.setAttribute("message", "삭제 완료");
			request.setAttribute("path", "./qnaList.qna?curPage=1");
		}else {
			request.setAttribute("message", "삭제 실패");
			request.setAttribute("path", "./qnaList.qna?curPage=1");
		}
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/result.jsp");

		return actionFoward;
	}
}