package com.fnw.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.util.DBConnector;
import com.fnw.util.MakeRow;

public class Book_TotalDAO {
	public void insert() {}
	public void delete() {}
	public void update() {}

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

		String sql ="select * from notice where num=?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);

		ResultSet rs = st.executeQuery();

		Book_TotalDTO noticeDTO=null;

		if(rs.next()) {
			noticeDTO = new Book_TotalDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setCompany(rs.getString("company"));
			noticeDTO.setPublish_date(rs.getDate("publish_date"));
			noticeDTO.setSection(rs.getString("section"));
			noticeDTO.setLibrary(rs.getInt("library"));
			noticeDTO.setState(rs.getInt("state"));
			noticeDTO.setRent_id(rs.getString("rent_id"));
			noticeDTO.setRent_count(rs.getInt("rent_count"));
		}

		DBConnector.disConnect(rs, st, con);
		
		return noticeDTO;

	}
	
	//list
	public ArrayList<Book_TotalDTO> selectList(MakeRow makeRow, String kind, String search) throws Exception {
		
		Connection con = DBConnector.getConnect();
		
		ArrayList<Book_TotalDTO> ar = new ArrayList<>();
		
		String sql = "select * from "
				+ "(select rownum R, N.* from "
				+ "(select * from book_total where "+ kind +" like ? order by num desc) N)"
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
			noticeDTO.setPublish_date(rs.getDate("publish_date"));
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
	public void rent() {}
	public void countUpdate() {}
}