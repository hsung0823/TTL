package com.fnw.book;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.util.DBConnector;
import com.fnw.util.MakeRow;

public class Book_Buy_WishDAO {
	public ArrayList<Book_Buy_WishDTO> selectList(String id, MakeRow makeRow, String kind, String search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from" + 
				"(select rownum R, N.* from" + 
				"(select * from book_buy_wish where "+kind+" like ? and id=? order by num asc) N)" + 
				"where R between ? and ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		st.setString(2, id);
		st.setInt(3, makeRow.getStartRow());
		st.setInt(4, makeRow.getLastRow());
		
		ResultSet rs = st.executeQuery();
		ArrayList<Book_Buy_WishDTO> list = new ArrayList<>();
		Book_Buy_WishDTO book_Buy_WishDTO = null;
		
		while(rs.next()) {
			book_Buy_WishDTO = new Book_Buy_WishDTO();
			book_Buy_WishDTO.setNum(rs.getInt("num"));
			book_Buy_WishDTO.setTitle(rs.getString("title"));
			book_Buy_WishDTO.setWriter(rs.getString("writer"));
			book_Buy_WishDTO.setPublish_date(rs.getString("publish_date"));
			book_Buy_WishDTO.setLibrary(rs.getInt("library"));
			book_Buy_WishDTO.setId(rs.getString("id"));
			book_Buy_WishDTO.setPrice(rs.getInt("price"));
			book_Buy_WishDTO.setState(rs.getInt("state"));
			
			list.add(book_Buy_WishDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		return list;
	}
	public int getTotalCount(String kind, String search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select nvl(count(num), 0) from book_buy_wish where "+ kind +" like ?" ;

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);

		DBConnector.disConnect(rs, st, con);
		return result;
	}
	public int delete(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "delete from book_buy_wish where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		int result = st.executeUpdate();
		
		return result;
	}
	/*public book_WishDTO selectOne(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from book_order where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		book_WishDTO bookOrderDTO = null;
		while(rs.next()) {
			bookOrderDTO = new book_WishDTO();
			bookOrderDTO.setNum(rs.getInt("num"));
			bookOrderDTO.setTitle(rs.getString("title"));
			bookOrderDTO.setWriter(rs.getString("writer"));
			bookOrderDTO.setCompany(rs.getString("company"));
			bookOrderDTO.setPublish_date(rs.getDate("publish_date"));
			bookOrderDTO.setContents(rs.getString("contents"));
			bookOrderDTO.setLibrary(rs.getInt("library"));
			bookOrderDTO.setId(rs.getString("id"));
			bookOrderDTO.setPrice(rs.getInt("price"));
			bookOrderDTO.setState(rs.getInt("state"));
			bookOrderDTO.setCancel(rs.getString("cancel"));
		}
		return bookOrderDTO;
	}

	public int update(book_WishDTO book_WishDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql="UPDATE book_order SET title=?, writer=?, company=?, publish_date=?, contents=?, price=?, library=? WHERE num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, book_WishDTO.getTitle());
		st.setString(2, book_WishDTO.getWriter());
		st.setString(3, book_WishDTO.getCompany());
		st.setDate(4, book_WishDTO.getPublish_date());
		st.setString(5, book_WishDTO.getContents());
		st.setInt(6, book_WishDTO.getPrice());
		st.setInt(7, book_WishDTO.getLibrary());
		st.setInt(8, book_WishDTO.getNum());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}*/
}
