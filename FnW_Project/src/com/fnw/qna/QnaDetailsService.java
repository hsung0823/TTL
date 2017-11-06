package com.fnw.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class QnaDetailsService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();

		QnaDTO qnaDTO = null;
		QnaDAO qnaDAO = new QnaDAO();
		try {
			qnaDTO = qnaDAO.selectOne(Integer.parseInt(request.getParameter("num")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("qnaDetails", qnaDTO);
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/qna/qnaDetails.jsp");

		return actionFoward;
	}
}