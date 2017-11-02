package com.fnw.market;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.util.DBConnector;

public class Market_Deal_DetailsDAO {
	public ArrayList<Market_Deal_DetailsDTO> selectList(String id) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql ="select rownum R, M.* from market_deal_details M where id=? order by num asc";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();

		ArrayList<Market_Deal_DetailsDTO> ar = new ArrayList<>();
		Market_Deal_DetailsDTO book_Deal_DetailsDTO = null;
		while(rs.next()) {
			book_Deal_DetailsDTO = new Market_Deal_DetailsDTO();
			book_Deal_DetailsDTO.setNum(rs.getInt("num"));
			book_Deal_DetailsDTO.setTitle(rs.getString("title"));
			book_Deal_DetailsDTO.setWriter(rs.getString("writer"));
			book_Deal_DetailsDTO.setCompany(rs.getString("company"));
			book_Deal_DetailsDTO.setPublish_date(rs.getDate("publish_date"));
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
			book_Deal_DetailsDTO.setPublish_date(rs.getDate("publish_date"));
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
}
