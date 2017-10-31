package com.fnw.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public ActionFoward doProcess(HttpServletRequest request, HttpServletResponse response);
}
