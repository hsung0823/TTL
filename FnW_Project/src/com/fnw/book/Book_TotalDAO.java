package com.fnw.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.util.DBConnector;
import com.fnw.util.MakeRow;

public class Book_TotalDAO {

	//totalCount
	public int getTotalCount(String kind, String search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select nvl(count(num), 0) from book_total where "+ kind +" like ?" ;
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);

		DBConnector.disConnect(rs, st, con);
		return result;
	}

	//view
	public Book_TotalDTO selectOne(int num) throws Exception{
		Connection con = DBConnector.getConnect();

		String sql ="select * from book_total where num=?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);

		ResultSet rs = st.executeQuery();

		Book_TotalDTO book_TotalDTO=null;

		if(rs.next()) {
			book_TotalDTO = new Book_TotalDTO();
			book_TotalDTO.setNum(rs.getInt("num"));
			book_TotalDTO.setTitle(rs.getString("title"));
			book_TotalDTO.setWriter(rs.getString("writer"));
			book_TotalDTO.setCompany(rs.getString("company"));
			book_TotalDTO.setPublish_date(rs.getString("publish_date"));
			book_TotalDTO.setSection(rs.getString("section"));
			book_TotalDTO.setLibrary(rs.getInt("library"));
			book_TotalDTO.setState(rs.getInt("state"));
			book_TotalDTO.setRent_id(rs.getString("rent_id"));
			book_TotalDTO.setRent_count(rs.getInt("rent_count"));
		}

		DBConnector.disConnect(rs, st, con);
		
		return book_TotalDTO;

	}
	
	//list
	public ArrayList<Book_TotalDTO> selectList(MakeRow makeRow, String kind, String search) throws Exception {
		
		Connection con = DBConnector.getConnect();
		
		ArrayList<Book_TotalDTO> ar = new ArrayList<>();
		
		String sql = "select * from "
				+ "(select rownum R, N.* from "
				+ "(select * from book_total where "+ kind +" like ? order by num asc) N)"
				+ "where R between ? and ?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		st.setInt(2, makeRow.getStartRow());
		st.setInt(3, makeRow.getLastRow());
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			Book_TotalDTO noticeDTO = new Book_TotalDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setCompany(rs.getString("company"));
			noticeDTO.setPublish_date(rs.getString("publish_date"));
			noticeDTO.setSection(rs.getString("section"));
			noticeDTO.setLibrary(rs.getInt("library"));
			noticeDTO.setState(rs.getInt("state"));
			noticeDTO.setRent_id(rs.getString("rent_id"));
			noticeDTO.setRent_count(rs.getInt("rent_count"));
			ar.add(noticeDTO);
		}

		DBConnector.disConnect(rs, st, con);

		return ar;
	}

	public int insert(Book_TotalDTO book_TotalDTO) throws Exception {
		Connection con =  DBConnector.getConnect();
		String sql = "insert into book_total values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, book_TotalDTO.getNum());
		st.setString(2, book_TotalDTO.getTitle());
		st.setString(3, book_TotalDTO.getWriter());
		st.setString(4, book_TotalDTO.getCompany());
		st.setString(5, book_TotalDTO.getPublish_date());
		st.setString(6, book_TotalDTO.getSection());
		st.setInt(7, book_TotalDTO.getLibrary());
		st.setString(8, book_TotalDTO.getType());
		st.setInt(9, book_TotalDTO.getState());
		st.setString(10, book_TotalDTO.getRent_id());
		st.setInt(11, book_TotalDTO.getRent_count());
		
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
		st.setString(4, book_TotalDTO.getPublish_date());
		st.setString(5, book_TotalDTO.getSection());
		st.setInt(6, book_TotalDTO.getLibrary());
		st.setString(7, book_TotalDTO.getType());
		st.setInt(8, book_TotalDTO.getState());
		st.setString(9, book_TotalDTO.getRent_id());
		st.setInt(10, book_TotalDTO.getRent_count());
		st.setInt(11, book_TotalDTO.getNum());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
}


