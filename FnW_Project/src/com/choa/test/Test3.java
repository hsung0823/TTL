package com.choa.test;

import java.sql.Date;
import java.util.StringTokenizer;

import com.fnw.book.Book_TotalDAO;
import com.fnw.book.Book_TotalDTO;
 
public class Test3 {
 
    public static void main(String[] args) {
         
         Book_TotalDTO book_TotalDTO = new Book_TotalDTO();
   
        String txt ="";
        
        
        // split을 이용한 문자열 분리
        int result=0;
        String[] txtArr1 = txt.split("@@");
        for(int i=0; i<txtArr1.length; i++)  {
       
        	for(int j=0; j<11; j++){
        		String[] txtArr2 = txtArr1[i].split("~~"); //한줄을 ~~로 파싱
        		
        		/*System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		System.out.println(j+"번 : "+txtArr2[j].trim());
        		j++;
        		j=0;*/
        		
        		
        		
        		book_TotalDTO.setNum(Integer.parseInt(txtArr2[j].trim()));
        		j++;
            	book_TotalDTO.setTitle(txtArr2[j].trim());
            	j++;
            	book_TotalDTO.setWriter(txtArr2[j].trim());
            	j++;
            	book_TotalDTO.setCompany(txtArr2[j].trim());
            	j++;
            	book_TotalDTO.setPublish_date(txtArr2[j].trim());
            	j++;
            	book_TotalDTO.setSection(txtArr2[j].trim());
            	j++;
            	book_TotalDTO.setLibrary(Integer.parseInt(txtArr2[j].trim()));
            	j++;
            	book_TotalDTO.setType(txtArr2[j].trim());
            	j++;
            	book_TotalDTO.setState(Integer.parseInt(txtArr2[j].trim()));
            	j++;
            	book_TotalDTO.setRent_id(txtArr2[j].trim());
            	j++;
            	book_TotalDTO.setRent_count(Integer.parseInt(txtArr2[j].trim()));
            	j++;
        		
        		Book_TotalDAO book_TotalDAO = new Book_TotalDAO();
        		
        		try {
					result = book_TotalDAO.insert(book_TotalDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        	}//for
        	
        }//for
        System.out.println(result);
        
     
   
    }
}


