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
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HashMap<String, Object> map;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	map = new HashMap<>();
    	//1. properties 파일명 구해오기
    	String fileName = config.getInitParameter("properties");
    	//2. 파일이 있는 디렉터리 실제경로 구하기
    	String realPath = config.getServletContext().getRealPath("WEB-INF/property");
    	//3. 파싱 준비
    	FileInputStream fi = null;
    	Properties properties = new Properties();
    
    	//4. 파싱
    	File f = new File(realPath, fileName);
    	try {
			fi = new FileInputStream(f);
			properties.load(fi); // 
			//5. key 구해오기 (Iterator)
			Iterator<Object> it = properties.keySet().iterator();
			
			while(it.hasNext()) {
				String key = (String)it.next();
				//6. key를 이용해서 value 구하기
				String value = (String)properties.get(key);
				//7. value 객체 생성
				Class obj = Class.forName(value);
				Object instance = obj.newInstance();
				//8. map 에 넣기
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
