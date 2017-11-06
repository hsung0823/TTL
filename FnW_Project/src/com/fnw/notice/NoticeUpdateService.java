package com.fnw.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.notice.NoticeDTO;

public class NoticeUpdateService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		NoticeDAO noticeDAO = new NoticeDAO();
		String method = request.getMethod();
		
		if(method.equals("POST")) {
			int result = this.doPost(request);
			
			if(result>0) {
				actionFoward.setCheck(false);
				actionFoward.setPath("./noticeList.notice");
				
			}else {
				request.setAttribute("message", "Update Fail");
				request.setAttribute("path", "./noticeList.notice");
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/common/result.jsp");
			}
			
		}else {
			NoticeDTO noticeDTO = this.doGet(request);
			if(noticeDTO != null) {
				request.setAttribute("notice", "notice");
				request.setAttribute("view", noticeDTO);
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/notice/noticeUpdate.jsp");
			}else {
				request.setAttribute("message", "No Contetns");
				request.setAttribute("path", "./noticeList.notice");
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/common/result.jsp");
			}
			
		}
		
		return actionFoward;
	}
	
	private NoticeDTO doGet(HttpServletRequest request) {
		int num = 0 ;
		NoticeDTO noticeDTO=null;
		try {
		num =Integer.parseInt(request.getParameter("num"));
		NoticeDAO noticeDAO = new NoticeDAO();
		noticeDTO=noticeDAO.selectOne(num);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return noticeDTO;
		
	}
	
	private int doPost(HttpServletRequest request) {
		NoticeDTO noticeDTO = new NoticeDTO();
		int result=0;
		NoticeDAO noticeDAO = new NoticeDAO();
		noticeDTO.setNum(Integer.parseInt(request.getParameter("num")));
		noticeDTO.setTitle(request.getParameter("title"));
		noticeDTO.setContents(request.getParameter("contents"));
		try {
			result = noticeDAO.update(noticeDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	

}
