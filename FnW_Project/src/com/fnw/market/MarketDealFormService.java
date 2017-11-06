package com.fnw.market;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;
import com.fnw.market.Market_OrderDAO;
import com.fnw.market.Market_OrderDTO;

public class MarketDealFormService implements Action {

	@Override
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();

		if(method.equals("GET")) {
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/market/marketDealForm.jsp");
		} else {
			Market_OrderDAO market_OrderDAO = new Market_OrderDAO();
			Market_OrderDTO market_OrderDTO = new Market_OrderDTO();
			market_OrderDTO.setTitle(request.getParameter("title"));
			market_OrderDTO.setWriter(request.getParameter("writer"));
			market_OrderDTO.setCompany(request.getParameter("company"));
			market_OrderDTO.setPublish_date(request.getParameter("publish_date"));
			market_OrderDTO.setPrice(Integer.parseInt(request.getParameter("price")));
			market_OrderDTO.setId(request.getParameter("id"));
			market_OrderDTO.setLibrary(Integer.parseInt(request.getParameter("library")));

			int result = 0;
			String message = null;

			try {
				result = market_OrderDAO.insert(market_OrderDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(result > 0) {
				message = "등록 완료";
			}else {
				message = "등록 실패";
			}
			request.setAttribute("message", message);
			request.setAttribute("path", "../index.jsp");
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		}

		return actionFoward;
	}

}
