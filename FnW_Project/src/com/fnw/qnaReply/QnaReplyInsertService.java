package com.fnw.qnaReply;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
public class QnaReplyInsertService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String message = request.getParameter("reply");
		Qna_ReplyDAO qna_ReplyDAO = new Qna_ReplyDAO();
		Qna_ReplyDTO qna_ReplyDTO = null;
		int result = 0;
		try {
			qna_ReplyDTO = new Qna_ReplyDTO();
			qna_ReplyDTO.setNum(1);
			qna_ReplyDTO.setWirter("@@");
			qna_ReplyDTO.setContents(message);
			qna_ReplyDTO.setRef(2);
			qna_ReplyDTO.setStep(2);
			qna_ReplyDTO.setDepth(2);
			result = qna_ReplyDAO.insert(qna_ReplyDTO);
			if(result>0) {
				request.setAttribute("message", "댓글 성공");
				request.setAttribute("path", "./qnaList.qna");
			}else {
				request.setAttribute("message", "댓글 실패");
				request.setAttribute("path", "./qnaList.qna");
			}
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actionFoward;
	}
}