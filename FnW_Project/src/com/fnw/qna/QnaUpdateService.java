package com.fnw.qna;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.member.MemberDTO;

public class QnaUpdateService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		int num = Integer.parseInt(request.getParameter("num"));
		if(method.equals("GET")) {
			QnaDTO qnaDTO = null;
			QnaDAO qnaDAO = new QnaDAO();
			try {
				qnaDTO = qnaDAO.selectOne(num);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("qnaDTO", qnaDTO);
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/qna/qnaUpdate.jsp");
		}else {
			QnaDTO qnaDTO = null;
			QnaDAO qnaDAO = new QnaDAO();
			int result = 0;
			try {
				qnaDTO = qnaDAO.selectOne(num);
				qnaDTO.setNum(num);
				qnaDTO.setType(Integer.parseInt(request.getParameter("type")));
				qnaDTO.setTitle(request.getParameter("title"));
				qnaDTO.setWriter(request.getParameter("writer"));
				qnaDTO.setContents(request.getParameter("contents"));
				qnaDTO.setWriter(request.getParameter("writer"));
				qnaDTO.setReg_date(Date.valueOf(request.getParameter("date")));
				qnaDTO.setHit(Integer.parseInt(request.getParameter("hit")));
				qnaDTO.setKind(Integer.parseInt(request.getParameter("kind")));
				try {
					result = qnaDAO.update(qnaDTO);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			if(result>0) {
				request.setAttribute("message", "수정 완료");
				request.setAttribute("path", "./qnaList.qna");
			}else {
				request.setAttribute("message", "수정 실패");
				request.setAttribute("path", "./qnaList.qna");
			}
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		}

		return actionFoward;
	}
}