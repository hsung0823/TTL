package com.fnw.qna;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.market.Market_Deal_DetailsDAO;
import com.fnw.member.MemberDTO;

public class QnaWriteService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		
		if(method.equals("GET")) {
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/qna/qnaWrite.jsp");
		}else {
			QnaDTO qnaDTO = null;
			QnaDAO qnaDAO = new QnaDAO();
			int result = 0;
			String message="";
			try {
				qnaDTO = new QnaDTO();
				qnaDTO.setNum(Integer.parseInt(request.getParameter("num")));
				qnaDTO.setType(Integer.parseInt(request.getParameter("type")));
				qnaDTO.setTitle(request.getParameter("title"));
				qnaDTO.setWriter(request.getParameter("writer"));
				qnaDTO.setContents(request.getParameter("contents"));
				qnaDTO.setWriter(request.getParameter("writer"));
				qnaDTO.setReg_date(Date.valueOf(request.getParameter("date")));
				qnaDTO.setHit(Integer.parseInt(request.getParameter("hit")));
				qnaDTO.setKind(Integer.parseInt(request.getParameter("kind")));
				result = qnaDAO.insert(qnaDTO);
				
				if(result > 0) {
					request.setAttribute("message", "등록 완료");
					request.setAttribute("path", "./qnaList.qna");
				}else {
					request.setAttribute("message", "실패");
					request.setAttribute("path", "./qnaList.qna");
				}
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/common/result.jsp");
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return actionFoward;
	}
}