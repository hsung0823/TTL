package com.fnw.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Object> map;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	map = new HashMap<>();
    	//1. 파일명 구하기
    	String fileName= config.getInitParameter("properties");
    	//2. 파일 실제 경로 구하기
    	String realPath= config.getServletContext().getRealPath("WEB-INF/property");
    	
    	
    	File f = new File(realPath, fileName);
    	//3. 파싱 준비
    	FileInputStream fi=null;
    	Properties properties = new Properties();
    	try {
		//4. 파일을 파싱
    		fi = new FileInputStream(f);
			properties.load(fi);
		//5. key를 이용해서 value 구하기
			Iterator<Object> it = properties.keySet().iterator();
			while(it.hasNext()) {
				String key = (String)it.next();
				String value = (String)properties.get(key);
		//6. value를 이용해서 객체 생성하기		
				Class obj= Class.forName(value);
				Object instance = obj.newInstance();
				System.out.println("Key : "+key);
				System.out.println("instance : "+instance);
		//7. key와 instance를 맵에 저장		
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		int sIndex = request.getContextPath().length();
		int lIndex = uri.lastIndexOf(".");
		uri = uri.substring(sIndex, lIndex);
		ActionFoward actionFoward=null;
		Action action=null;
		//-------------------------------
		action = (Action)map.get(uri);
		actionFoward = action.doProcess(request, response);		//-------------------------------
		
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
