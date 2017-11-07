package com.fnw.qna;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.qnaReply.Qna_ReplyDAO;
import com.fnw.qnaReply.Qna_ReplyDTO;

public class QnaDetailsCheckService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		String method = request.getMethod();
		int num = 0;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		} catch (Exception e) {
			num = 0;
		}
		if(method.equals("GET")) {
			request.setAttribute("num", num);
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/qna/qnaDetailsCheck.jsp");
		}else {
			QnaDAO qnaDAO = new QnaDAO();
			QnaDTO qnaDTO = null;
	
			try {
				qnaDTO = qnaDAO.pwCheck(Integer.parseInt(request.getParameter("num")),request.getParameter("pw"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(qnaDTO!=null) {
				Qna_ReplyDAO qna_ReplyDAO = new Qna_ReplyDAO();
				ArrayList<Qna_ReplyDTO> list = new ArrayList<>();
				try {
					list = qna_ReplyDAO.selectList(num);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				request.setAttribute("rDTO", list);
				request.setAttribute("qnaDTO", qnaDTO);
				request.setAttribute("num", qnaDTO.getNum());
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/qna/qnaDetails.jsp");
			}else {
				request.setAttribute("message", "비밀번호 다시 입력하세요.");
				request.setAttribute("path", "../qna/qnaList.qna");
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/common/result.jsp");
			}
		}
		
		return actionFoward;
	}
}