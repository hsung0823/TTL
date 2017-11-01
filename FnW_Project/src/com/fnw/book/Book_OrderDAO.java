package com.fnw.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.util.DBConnector;

public class Book_OrderDAO {
	public ArrayList<Book_OrderDTO> selectList(String id) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from book_order where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		ArrayList<Book_OrderDTO> list = new ArrayList<>();
		Book_OrderDTO book_OrderDTO = null;
		
		while(rs.next()) {
			book_OrderDTO = new Book_OrderDTO();
			book_OrderDTO.setNum(rs.getInt("num"));
			book_OrderDTO.setTitle(rs.getString("title"));
			book_OrderDTO.setWriter(rs.getString("writer"));
			book_OrderDTO.setCompany(rs.getString("company"));
			book_OrderDTO.setPublish_date(rs.getDate("publish_date"));
			book_OrderDTO.setContents(rs.getString("contents"));
			book_OrderDTO.setId(rs.getString("id"));
			book_OrderDTO.setPrice(rs.getInt("price"));
			book_OrderDTO.setLibrary(rs.getInt("library"));
			book_OrderDTO.setPrice(rs.getInt("price"));
			book_OrderDTO.setState(rs.getInt("state"));
			book_OrderDTO.setCancle(rs.getString("cancle"));
			
			list.add(book_OrderDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		return list;
	}
}
