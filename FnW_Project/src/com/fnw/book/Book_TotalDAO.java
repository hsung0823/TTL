package com.fnw.book;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fnw.util.DBConnector;

public class Book_TotalDAO {
	public int insert(Book_TotalDTO book_TotalDTO) throws Exception
	{
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, book_TotalDTO.getNum());
		st.setString(2, book_TotalDTO.getTitle());
		st.setString(3, book_TotalDTO.getWriter());
		st.setString(4, book_TotalDTO.getCompany());
		st.setDate(5, book_TotalDTO.getPublish_date());
		st.setString(6, book_TotalDTO.getSection());
		st.setInt(7, book_TotalDTO.getLibrary());
		st.setInt(8, book_TotalDTO.getType());
		st.setInt(9, book_TotalDTO.getState());
		st.setString(10, book_TotalDTO.getRent_id());
		st.setInt(11, book_TotalDTO.getRent_count());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	public void delete() {}
	public void update() {}
	public void getTotalCount() {}
	public void selectOne() {}
	public void selectList() {}
	public void rent() {}
	public void countUpdate() {}
}
