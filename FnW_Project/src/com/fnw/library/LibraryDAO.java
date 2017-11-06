package com.fnw.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fnw.book.Book_TotalDTO;
import com.fnw.util.DBConnector;
import com.fnw.util.MakeRow;
import com.fnw.util.PageMaker;

public class LibraryDAO {

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

	//book_rent
	public int bookRent(int num, String rent_id) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "update book_total set state = 1, rent_id = ?, rent_count = "
				+ "(select rent_count from book_total where num = ?)+1 where num = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, rent_id);
		st.setInt(2, num);
		st.setInt(3, num);

		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

	//selectOne
	public Book_TotalDTO selectOne(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		Book_TotalDTO book_TotalDTO = null;
		String sql = "select * from book_total where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);

		ResultSet rs = st.executeQuery();
		while(rs.next()) {
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

	//Book_selectList
	public ArrayList<Book_TotalDTO> selectList(MakeRow makeRow, String kind, String search, int library) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from (select rownum R, N.* from "
				+ "(select * from book_total where" + kind + "like ? "
				+ "order by num asc) N) "
				+ "where R between ? and ? and library = ?";

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		st.setInt(2, makeRow.getStartRow());
		st.setInt(3, makeRow.getLastRow());
		st.setInt(4, library);

		ArrayList<Book_TotalDTO> ar = new ArrayList<>();
		Book_TotalDTO book_TotalDTO = null;

		ResultSet rs = st.executeQuery();
		while(rs.next()) {
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
			ar.add(book_TotalDTO);
		}

		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	
	
	//Library_selectList
	public ArrayList<LibraryDTO> selectList() throws Exception {
		Connection con = DBConnector.getConnect();
		String sql ="select * from library order by library asc";
		PreparedStatement st = con.prepareStatement(sql);
		ArrayList<LibraryDTO> ar = new ArrayList<>();
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			LibraryDTO libraryDTO = new LibraryDTO();
			libraryDTO.setLibrary(rs.getInt("library"));
			libraryDTO.setName(rs.getString("name"));
			libraryDTO.setArea(rs.getString("area"));
			libraryDTO.setBudget(rs.getInt("budget"));
			libraryDTO.setX_position(rs.getDouble("x_position"));
			libraryDTO.setY_position(rs.getDouble("y_position"));
			ar.add(libraryDTO);
			
		}
		
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
}
