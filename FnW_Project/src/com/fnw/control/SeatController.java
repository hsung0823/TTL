package com.fnw.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fnw.action.Action;
import com.fnw.action.ActionFoward;



/**
 * Servlet implementation class SeatController
 */
@WebServlet("/SeatController")
public class SeatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HashMap<String, Object> map;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	map = new HashMap<>();
    	
    	String fileName = config.getInitParameter("properties");
    	String realPath = config.getServletContext().getRealPath("WEB-INF/property");
    	
    	FileInputStream fi = null;
    	Properties properties = new Properties();
    	
    	File f = new File(realPath, fileName);
    	
    	try {
			fi = new FileInputStream(f);
			properties.load(fi);
			
			Iterator<Object> it = properties.keySet().iterator();
			
			while(it.hasNext()) {
				String key = (String)it.next();
				
				String value = (String)properties.get(key);
				
				Class obj = Class.forName(value);
				Object instance = obj.newInstance();
				
				
				map.put(key, instance);
				
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    			
    	 
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri =request.getRequestURI();
		int sIndex = request.getContextPath().length();
		int lIndex = uri.lastIndexOf(".");
		uri = uri.substring(sIndex, lIndex);
		
		Action action = null;
		ActionFoward actionFoward = null;

		action = (Action)map.get(uri);
		actionFoward = action.doProcess(request, response);
		
		if(actionFoward.isCheck()) {
			RequestDispatcher view = request.getRequestDispatcher(actionFoward.getPath());
			view.forward(request, response);
		}else {
			response.sendRedirect(actionFoward.getPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
