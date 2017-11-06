package com.fnw.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;

public class NoticeWriteService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod();
		ActionFoward actionFoward = new ActionFoward();
		if(method.equals("POST")) {
			NoticeDAO noticeDAO = new NoticeDAO();
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle(request.getParameter("title"));
			noticeDTO.setContents(request.getParameter("contents"));
			noticeDTO.setWriter(request.getParameter("writer"));
			int result=0;
			try {
				result = noticeDAO.insert(noticeDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result>0) {
				actionFoward.setCheck(false);
				actionFoward.setPath("./noticeList.notice");
			}else {
				actionFoward.setCheck(false);
				actionFoward.setPath("../index.jsp");
			}
			
		}else {
			request.setAttribute("notice", "notice");
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/notice/noticeWrite.jsp");
		}
		return actionFoward;
	}

}
