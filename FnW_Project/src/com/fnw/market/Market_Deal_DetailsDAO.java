package com.fnw.market;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.util.DBConnector;
import com.fnw.util.MakeRow;

public class Market_Deal_DetailsDAO {
	public ArrayList<Market_Deal_DetailsDTO> selectList(String id, MakeRow makeRow, String search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from "
				+ "(select rownum R, N.* from "
				+ "(select * from market_deal_details where T_date < ? and id=? order by num asc) N)"
				+ "where R between ? and ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, search);
		st.setString(2, id);
		st.setInt(3, makeRow.getStartRow());
		st.setInt(4, makeRow.getLastRow());
		ResultSet rs = st.executeQuery();

		ArrayList<Market_Deal_DetailsDTO> ar = new ArrayList<>();
		Market_Deal_DetailsDTO book_Deal_DetailsDTO = null;
		while(rs.next()) {
			book_Deal_DetailsDTO = new Market_Deal_DetailsDTO();
			book_Deal_DetailsDTO.setId(rs.getString("id"));
			book_Deal_DetailsDTO.setNum(rs.getInt("num"));
			book_Deal_DetailsDTO.setTitle(rs.getString("title"));
			book_Deal_DetailsDTO.setWriter(rs.getString("writer"));
			book_Deal_DetailsDTO.setCompany(rs.getString("company"));
			book_Deal_DetailsDTO.setPublish_date(rs.getString("publish_date"));
			book_Deal_DetailsDTO.setId(rs.getString("id"));
			book_Deal_DetailsDTO.setT_date(rs.getDate("t_date"));
			book_Deal_DetailsDTO.setPrice(rs.getInt("price"));
			book_Deal_DetailsDTO.setLibrary(rs.getInt("library"));
			book_Deal_DetailsDTO.setKind(rs.getInt("kind"));
			book_Deal_DetailsDTO.setState(rs.getInt("state"));
			book_Deal_DetailsDTO.setDelivery(rs.getInt("delivery"));
			ar.add(book_Deal_DetailsDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	public Market_Deal_DetailsDTO selectOne(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from market_deal_details where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);

		ResultSet rs = st.executeQuery();

		Market_Deal_DetailsDTO book_Deal_DetailsDTO = null;
		while(rs.next()) {
			book_Deal_DetailsDTO = new Market_Deal_DetailsDTO();
			book_Deal_DetailsDTO.setNum(rs.getInt("num"));
			book_Deal_DetailsDTO.setTitle(rs.getString("title"));
			book_Deal_DetailsDTO.setWriter(rs.getString("writer"));
			book_Deal_DetailsDTO.setCompany(rs.getString("company"));
			book_Deal_DetailsDTO.setPublish_date(rs.getString("publish_date"));
			book_Deal_DetailsDTO.setId(rs.getString("id"));
			book_Deal_DetailsDTO.setT_date(rs.getDate("t_date"));
			book_Deal_DetailsDTO.setPrice(rs.getInt("price"));
			book_Deal_DetailsDTO.setLibrary(rs.getInt("library"));
			book_Deal_DetailsDTO.setKind(rs.getInt("kind"));
			book_Deal_DetailsDTO.setState(rs.getInt("state"));
			book_Deal_DetailsDTO.setDelivery(rs.getInt("delivery"));
		}
		DBConnector.disConnect(rs, st, con);
		return book_Deal_DetailsDTO;
	}
	public int delete(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "delete from market_deal_details where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		int result = st.executeUpdate();
		
		return result;
	}
	public int getTotalCount(String search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select nvl(count(num), 0) from market_deal_details where t_date < ?" ;
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, search);
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);

		DBConnector.disConnect(rs, st, con);
		return result;
	}
}
