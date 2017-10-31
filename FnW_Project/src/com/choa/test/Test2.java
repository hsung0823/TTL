package com.choa.test;

import java.sql.Date;
import java.util.StringTokenizer;

import com.fnw.book.Book_TotalDAO;
import com.fnw.book.Book_TotalDTO;
 
public class Test2 {
 
    public static void main(String[] args) {
         
         Book_TotalDTO book_TotalDTO = new Book_TotalDTO();
   
        String txt = "1	~~	(실력이 탐나는)포토샵 일러스트레이터 CS6	~~	유진영	~~	정보문화사	~~	2014	~~	a.001	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"2	~~	(이주영 선생님의)책으로 행복한 교실 이야기	~~	이주영	~~	행복한아침독서	~~	2014	~~	a.002	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"3	~~	SketchBook Pro: 디지털 스케치 쉽게하기	~~	노영주	~~	정보문화사	~~	2014	~~	a.003	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"4	~~	낭독은 입문학이다	~~	김보경	~~	현자의마을	~~	2014	~~	a.004	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"5	~~	느리게 읽기	~~	데이비드 미킥스	~~	위즈덤하우스	~~	2014	~~	a.005	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"6	~~	답답해서 내가 쓴 지식사전 :  지리편	~~	하누리	~~	제이그룹	~~	2014	~~	a.006	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"7	~~	대통령의 글쓰기	~~	강원국	~~	메디치미디어	~~	2014	~~	a.007	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"8	~~	대한민국 소프트웨어 성공 방정식	~~	김재호	~~	제이펍	~~	2014	~~	a.008	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"9	~~	마음 독서	~~	장길섭	~~	나마스테	~~	2014	~~	a.009	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"10	~~	스타트업 똑똑하게 시작하라	~~	최환진	~~	지앤선	~~	2014	~~	a.010	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"11	~~	왜 책을 만드는가	~~	맥스위니스 편집부 (엮음)	~~	미메시스	~~	2014	~~	a.011	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"12	~~	월스트리트저널 인포그래픽 가이드	~~	도나 M. 웡	~~	인사이트	~~	2014	~~	a.012	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"13	~~	자바를 다루는 기술	~~	김병부	~~	길벗	~~	2014	~~	a.013	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"14	~~	좋아 보이는 것들의 비밀 인포그래픽	~~	김묘영	~~	길벗	~~	2014	~~	a.014	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@\r\n" + 
        		"15	~~	토론하는 호모루덴스	~~	강경순	~~	교육과학사	~~	2014	~~	a.015	~~	  1 	~~	총류	~~	0	~~	0	~~	0	@@";
         
         
        // StringTokenizer를 이용한 문자열 분리
        //StringTokenizer tokens = new StringTokenizer(txt);
         
       /* String num    = tokens.nextToken("~~") ;   // 이름
        String title     = tokens.nextToken("~~") ;   // 나이
        String writer    = tokens.nextToken("~~") ;   // 성별
        String company     = tokens.nextToken("~~") ;   // 지역
        String publish_date     = tokens.nextToken("~~") ;
        String section     = tokens.nextToken("~~") ;
        String library     = tokens.nextToken("~~") ;
        String type     = tokens.nextToken("~~") ;
        String state     = tokens.nextToken("~~") ;
        String rent_id     = tokens.nextToken("~~") ;
        String rent_count     = tokens.nextToken("~~") ;
        */
        /* 
        System.out.println("[StringTokenizer 이용]") ;
        System.out.println(num.trim()) ;
        System.out.println(title.trim()) ;
        System.out.println(writer.trim()) ;
        System.out.println(company.trim()) ;
        System.out.println(publish_date.trim()) ;
        System.out.println(section.trim()) ;
        System.out.println(library.trim()) ;
        System.out.println(state.trim()) ;
        System.out.println(rent_id.trim()) ;
        System.out.println(rent_count.trim()) ;         
        System.out.println("") ;
         */
         
         
        // split을 이용한 문자열 분리
        String[] txtArr1 = txt.split("@@");
        for(int i=0; i<txtArr1.length; i++)
        {
        	
        	for(int j=0; j<11; j++)
        	{
        		String[] txtArr2 = txtArr1[i].split("~~");
        		
        		System.out.println(j+" : "+txtArr2[j].trim());
        		
        		
        	/*	book_TotalDTO.setNum(Integer.parseInt(txtArr2[j].trim()));
            	book_TotalDTO.setTitle(txtArr2[j].trim());
            	book_TotalDTO.setWriter(txtArr2[j].trim());
            	book_TotalDTO.setCompany(txtArr2[j].trim());
            	book_TotalDTO.setPublish_date(Date.valueOf(txtArr2[j].trim()));
            	book_TotalDTO.setSection(txtArr2[j].trim());
            	book_TotalDTO.setLibrary(Integer.parseInt(txtArr2[j].trim()));
            	book_TotalDTO.setType(Integer.parseInt(txtArr2[j].trim()));
            	book_TotalDTO.setState(Integer.parseInt(txtArr2[j].trim()));
            	book_TotalDTO.setRent_id(txtArr2[j].trim());
            	book_TotalDTO.setRent_count(Integer.parseInt(txtArr2[j].trim()));*/
        		
        		
        		/*Book_TotalDAO book_TotalDAO = new Book_TotalDAO();
        		try {
					book_TotalDAO.insert(book_TotalDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
        		}
        	
        	
        	//System.out.println(txtArr1[i]);
        }
        
      /*  for(int i=0; i < txtArr2.length; i++)
        {
        	
        		System.out.println(txtArr1[i].trim());
        	
        	book_TotalDTO.setNum(Integer.parseInt(txtArr[i].trim()));
        	book_TotalDTO.setTitle(txtArr[i].trim());
        	book_TotalDTO.setWriter(txtArr[i].trim());
        	book_TotalDTO.setCompany(txtArr[i].trim());
        	book_TotalDTO.setPublish_date(Date.valueOf(txtArr[i].trim()));
        	book_TotalDTO.setSection(txtArr[i].trim());
        	book_TotalDTO.setLibrary(Integer.parseInt(txtArr[i].trim()));
        	book_TotalDTO.setType(Integer.parseInt(txtArr[i].trim()));
        	book_TotalDTO.setState(Integer.parseInt(txtArr[i].trim()));
        	book_TotalDTO.setRent_id(txtArr[i].trim());
        	book_TotalDTO.setRent_count(Integer.parseInt(txtArr[i].trim()));
          
        }*/
         
   
    }
}


