package com.fnw.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fnw.member.MemberDTO;
import com.fnw.util.DBConnector;
import com.fnw.util.MakeRow;

public class Book_Rent_DetailsDAO {
	public ArrayList<Book_Rent_DetailsDTO> selectList(String id, MakeRow makeRow, String search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from "
				+ "(select rownum R, N.* from "
				+ "(select * from book_rent_details where in_time< ? and id=? order by num asc) N)"
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, search);
		st.setString(2, id);
		st.setInt(3, makeRow.getStartRow());
		st.setInt(4, makeRow.getLastRow());
		
		ArrayList<Book_Rent_DetailsDTO> list = new ArrayList<>();
		ResultSet rs = st.executeQuery();
		
		Book_Rent_DetailsDTO book_Rent_DetailsDTO = null;
		while(rs.next()) {
			book_Rent_DetailsDTO = new Book_Rent_DetailsDTO();
			book_Rent_DetailsDTO.setNum(rs.getInt("num"));
			book_Rent_DetailsDTO.setTitle(rs.getString("title"));
			book_Rent_DetailsDTO.setSection(rs.getString("section"));
			book_Rent_DetailsDTO.setWriter(rs.getString("writer"));
			book_Rent_DetailsDTO.setCompany(rs.getString("company"));
			book_Rent_DetailsDTO.setPublish_date(rs.getString("publish_date"));
			book_Rent_DetailsDTO.setId(rs.getString("id"));
			book_Rent_DetailsDTO.setLibrary(rs.getInt("library"));
			book_Rent_DetailsDTO.setIn_time(rs.getDate("in_time"));
			book_Rent_DetailsDTO.setOut_time(rs.getDate("out_time"));
			book_Rent_DetailsDTO.setLate_date(rs.getInt("late_date"));
			
			list.add(book_Rent_DetailsDTO);
		}
		
		DBConnector.disConnect(rs, st, con);
		return list;
	}
	public Book_Rent_DetailsDTO selectOne(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from book_rent_details where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		Book_Rent_DetailsDTO book_Rent_DetailsDTO = null;
		while(rs.next()) {
			book_Rent_DetailsDTO = new Book_Rent_DetailsDTO();
			book_Rent_DetailsDTO.setNum(rs.getInt("num"));
			book_Rent_DetailsDTO.setTitle(rs.getString("title"));
			book_Rent_DetailsDTO.setSection(rs.getString("section"));
			book_Rent_DetailsDTO.setWriter(rs.getString("writer"));
			book_Rent_DetailsDTO.setCompany(rs.getString("company"));
			book_Rent_DetailsDTO.setPublish_date(rs.getString("publish_date"));
			book_Rent_DetailsDTO.setId(rs.getString("id"));
			book_Rent_DetailsDTO.setLibrary(rs.getInt("library"));
			book_Rent_DetailsDTO.setIn_time(rs.getDate("in_time"));
			book_Rent_DetailsDTO.setOut_time(rs.getDate("out_time"));
			book_Rent_DetailsDTO.setLate_date(rs.getInt("late_date"));
		}
		return book_Rent_DetailsDTO;
	}
	public int delete(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "delete from book_rent_details where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		int result = st.executeUpdate();
		
		return result;
	}
	public int getTotalCount(String search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select nvl(count(num), 0) from book_rent_details where in_time < ?" ;
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, search);
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);

		DBConnector.disConnect(rs, st, con);
		return result;
	}
}
