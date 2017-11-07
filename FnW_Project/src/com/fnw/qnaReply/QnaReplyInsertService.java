package com.fnw.qnaReply;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.qna.QnaDAO;
import com.fnw.qna.QnaDTO;
public class QnaReplyInsertService implements Action {
	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String message = request.getParameter("reply");
		int num = Integer.parseInt(request.getParameter("num"));
		Qna_ReplyDAO qna_ReplyDAO = new Qna_ReplyDAO();
		Qna_ReplyDTO qna_ReplyDTO = null;
		
		QnaDAO qnaDAO = new QnaDAO();
		QnaDTO qnaDTO = null;
		try {
			qnaDTO = qnaDAO.selectOne(num);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		int result = 0;
		try {
			qna_ReplyDTO = new Qna_ReplyDTO();
			qna_ReplyDTO.setNum(qnaDTO.getNum());
			qna_ReplyDTO.setWriter(qnaDTO.getWriter());
			qna_ReplyDTO.setContents(message);
			qna_ReplyDTO.setRef(qnaDTO.getNum());
			qna_ReplyDTO.setStep(0);
			qna_ReplyDTO.setDepth(0);
			result = qna_ReplyDAO.insert(qna_ReplyDTO);
			if(result>0) {
				request.setAttribute("message", "댓글 성공");
				request.setAttribute("path", "../qna/qnaList.qna");
			}else {
				request.setAttribute("message", "댓글 실패");
				request.setAttribute("path", "../qna/qnaList.qna");
			}
			request.setAttribute("rDTO", qna_ReplyDTO);
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actionFoward;
	}
}