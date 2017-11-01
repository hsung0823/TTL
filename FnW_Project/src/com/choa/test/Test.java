package com.choa.test;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.fnw.book.Book_TotalDTO;



public class Test {

	public static void main(String[] args)throws Exception {

		File file = new File("E:\\", "new.txt");
		FileReader fr= null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		BufferedReader br = new BufferedReader(fr);
		String str=null;
		StringTokenizer st= null;
		ArrayList<Book_TotalDTO> ar = new ArrayList<>();
		
		while(true) {
			str = br.readLine(); // new �ش�Exception()
			if(str==null) {
				break;
			}
			str=str.trim();

			st = new StringTokenizer(str, "	~~	");
			while(st.hasMoreTokens()) {
				Book_TotalDTO book_TotalDTO = new Book_TotalDTO();
				
				book_TotalDTO.setNum(Integer.parseInt(st.nextToken().trim()));
				System.out.println("d");
				book_TotalDTO.setTitle(st.nextToken().trim());
				book_TotalDTO.setWriter(st.nextToken().trim());
				book_TotalDTO.setCompany(st.nextToken().trim());
				System.out.println("c");
			
				System.out.println(Date.valueOf((st.nextToken().trim())));
				
				book_TotalDTO.setPublish_date(st.nextToken().trim());
				book_TotalDTO.setSection(st.nextToken().trim());
				book_TotalDTO.setLibrary(Integer.parseInt(st.nextToken().trim()));
				book_TotalDTO.setType(st.nextToken().trim());
				book_TotalDTO.setState(Integer.parseInt(st.nextToken().trim()));
				book_TotalDTO.setRent_id(st.nextToken().trim());
				book_TotalDTO.setRent_count(Integer.parseInt(st.nextToken().trim()));
				ar.add(book_TotalDTO);
				System.out.println(book_TotalDTO.getWriter());
			}
		}
		
		
		br.close();
		fr.close();

		
		
	}//

}
