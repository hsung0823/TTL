package com.fnw.book;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fnw.util.DBConnector;

public class Book_TotalDAO {
	public int insert1(Book_TotalDTO book_TotalDTO) throws Exception
	{
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total (num) values(?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, book_TotalDTO.getNum());
		/*st.setString(2, book_TotalDTO.getTitle());
		st.setString(3, book_TotalDTO.getWriter());
		st.setString(4, book_TotalDTO.getCompany());
		st.setDate(5, book_TotalDTO.getPublish_date());
		st.setString(6, book_TotalDTO.getSection());
		st.setInt(7, book_TotalDTO.getLibrary());
		st.setInt(8, book_TotalDTO.getType());
		st.setInt(9, book_TotalDTO.getState());
		st.setString(10, book_TotalDTO.getRent_id());
		st.setInt(11, book_TotalDTO.getRent_count());*/
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	public int insert2(Book_TotalDTO book_TotalDTO) throws Exception
	{
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total (title) values(?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, book_TotalDTO.getTitle());
		
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	public int insert3(Book_TotalDTO book_TotalDTO) throws Exception
	{
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total (writer) values(?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, book_TotalDTO.getWriter());
		
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	public int insert4(Book_TotalDTO book_TotalDTO) throws Exception
	{
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total (company) values(?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, book_TotalDTO.getCompany());
		
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	public int insert5(Book_TotalDTO book_TotalDTO) throws Exception
	{
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total (publish_date) values(?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setDate(1, book_TotalDTO.getPublish_date());
		
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	public int insert6(Book_TotalDTO book_TotalDTO) throws Exception
	{
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total (section) values(?)";
		PreparedStatement st = con.prepareStatement(sql);
	
		st.setString(1, book_TotalDTO.getSection());
		
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	public int insert7(Book_TotalDTO book_TotalDTO) throws Exception
	{
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total (library) values(?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, book_TotalDTO.getLibrary());
		
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	public int insert8(Book_TotalDTO book_TotalDTO) throws Exception
	{
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total (type) values(?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, book_TotalDTO.getType());
	
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	public int insert9(Book_TotalDTO book_TotalDTO) throws Exception
	{
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total (state) values(?)";
		PreparedStatement st = con.prepareStatement(sql);
	
		st.setInt(1, book_TotalDTO.getState());

		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	public int insert10(Book_TotalDTO book_TotalDTO) throws Exception
	{
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total (rent_id) values(?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, book_TotalDTO.getRent_id());

		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	public int insert11(Book_TotalDTO book_TotalDTO) throws Exception
	{
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total (rent_count) values(?)";
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, book_TotalDTO.getRent_count());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}

	
	public int update(Book_TotalDTO book_TotalDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql="UPDATE book_total SET title=?, writer=?, company=?, publish_date=?, section=?, library=?, type=?, state=?, rent_id=?, rent_count=? WHERE num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, book_TotalDTO.getTitle());
		st.setString(2, book_TotalDTO.getWriter());
		st.setString(3, book_TotalDTO.getCompany());
		st.setDate(4, book_TotalDTO.getPublish_date());
		st.setString(5, book_TotalDTO.getSection());
		st.setInt(6, book_TotalDTO.getLibrary());
		st.setInt(7, book_TotalDTO.getType());
		st.setInt(8, book_TotalDTO.getState());
		st.setString(9, book_TotalDTO.getRent_id());
		st.setInt(10, book_TotalDTO.getRent_count());
		st.setInt(11, book_TotalDTO.getNum());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	public void getTotalCount() {}
	public void selectOne() {}
	public void selectList() {}
	public void rent() {}
	public void countUpdate() {}
}
