package com.fnw.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.util.DBConnector;
import com.fnw.util.MakeRow;

public class Book_OrderDAO {

	//구매 도서 신청
	public int insert(Book_OrderDTO book_OrderDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "insert into book_order values((select nvl(max(num),0) from book_order)+1,?,?,?,?,?,?,?,?,1,0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, book_OrderDTO.getTitle());
		st.setString(2, book_OrderDTO.getWriter());
		st.setString(3, book_OrderDTO.getCompany());
		st.setString(4, book_OrderDTO.getPublish_date());
		st.setString(5, book_OrderDTO.getContents());
		st.setString(6, book_OrderDTO.getId());
		st.setInt(7, book_OrderDTO.getPrice());
		st.setInt(8, book_OrderDTO.getLibrary());

		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

	public ArrayList<Book_OrderDTO> selectList(String id, MakeRow makeRow, String kind, String search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from" + 
				"(select rownum R, N.* from" + 
				"(select * from book_order where "+kind+" like ? and id=? order by num asc) N)" + 
				"where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		st.setString(2, id);
		st.setInt(3, makeRow.getStartRow());
		st.setInt(4, makeRow.getLastRow());

		ResultSet rs = st.executeQuery();
		ArrayList<Book_OrderDTO> list = new ArrayList<>();
		Book_OrderDTO book_OrderDTO = null;

		while(rs.next()) {
			book_OrderDTO = new Book_OrderDTO();
			book_OrderDTO.setNum(rs.getInt("num"));
			book_OrderDTO.setTitle(rs.getString("title"));
			book_OrderDTO.setWriter(rs.getString("writer"));
			book_OrderDTO.setCompany(rs.getString("company"));
			book_OrderDTO.setPublish_date(rs.getString("publish_date"));
			book_OrderDTO.setContents(rs.getString("contents"));
			book_OrderDTO.setId(rs.getString("id"));
			book_OrderDTO.setPrice(rs.getInt("price"));
			book_OrderDTO.setLibrary(rs.getInt("library"));
			book_OrderDTO.setPrice(rs.getInt("price"));
			book_OrderDTO.setState(rs.getInt("state"));
			book_OrderDTO.setCancel(rs.getString("cancel"));

			list.add(book_OrderDTO);
		}

		DBConnector.disConnect(rs, st, con);
		return list;
	}
	public int getTotalCount(String kind, String search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select nvl(count(num), 0) from book_order where "+ kind +" like ?" ;

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);

		DBConnector.disConnect(rs, st, con);
		return result;
	}
	public Book_OrderDTO selectOne(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from book_order where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);

		ResultSet rs = st.executeQuery();
		Book_OrderDTO bookOrderDTO = null;
		while(rs.next()) {
			bookOrderDTO = new Book_OrderDTO();
			bookOrderDTO.setNum(rs.getInt("num"));
			bookOrderDTO.setTitle(rs.getString("title"));
			bookOrderDTO.setWriter(rs.getString("writer"));
			bookOrderDTO.setCompany(rs.getString("company"));
			bookOrderDTO.setPublish_date(rs.getString("publish_date"));
			bookOrderDTO.setContents(rs.getString("contents"));
			bookOrderDTO.setLibrary(rs.getInt("library"));
			bookOrderDTO.setId(rs.getString("id"));
			bookOrderDTO.setPrice(rs.getInt("price"));
			bookOrderDTO.setState(rs.getInt("state"));
			bookOrderDTO.setCancel(rs.getString("cancel"));
		}
		return bookOrderDTO;
	}
	public int delete(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "delete from book_order where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);

		int result = st.executeUpdate();

		return result;
	}
	public int update(Book_OrderDTO book_OrderDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql="UPDATE book_order SET title=?, writer=?, company=?, publish_date=?, contents=?, price=?, library=? WHERE num=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, book_OrderDTO.getTitle());
		st.setString(2, book_OrderDTO.getWriter());
		st.setString(3, book_OrderDTO.getCompany());
		st.setString(4, book_OrderDTO.getPublish_date());
		st.setString(5, book_OrderDTO.getContents());
		st.setInt(6, book_OrderDTO.getPrice());
		st.setInt(7, book_OrderDTO.getLibrary());
		st.setInt(8, book_OrderDTO.getNum());

		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
}
