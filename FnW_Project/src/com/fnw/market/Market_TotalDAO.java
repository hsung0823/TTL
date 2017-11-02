package com.fnw.market;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.util.DBConnector;

public class Market_TotalDAO {
	public ArrayList<Market_TotalDTO> selectList(String id) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql ="select rownum R, M.* from market_total M where id=? order by num asc";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();

		ArrayList<Market_TotalDTO> ar = new ArrayList<>();
		Market_TotalDTO market_TotalDTO = null;
		while(rs.next()) {
			market_TotalDTO = new Market_TotalDTO();
			market_TotalDTO.setNum(rs.getInt("num"));
			market_TotalDTO.setTitle(rs.getString("title"));
			market_TotalDTO.setWriter(rs.getString("writer"));
			market_TotalDTO.setCompany(rs.getString("company"));
			market_TotalDTO.setPublish_date(rs.getDate("publish_date"));
			market_TotalDTO.setLibrary(rs.getInt("library"));
			market_TotalDTO.setPrice(rs.getInt("price"));
			market_TotalDTO.setId(rs.getString("id"));
			market_TotalDTO.setWish(rs.getInt("wish"));
			market_TotalDTO.setApproval(rs.getInt("approval"));
			market_TotalDTO.setBook_state(rs.getInt("book_state"));
			ar.add(market_TotalDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	public Market_TotalDTO selectOne(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from market_total where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);

		ResultSet rs = st.executeQuery();

		Market_TotalDTO market_TotalDTO = null;
		while(rs.next()) {
			market_TotalDTO = new Market_TotalDTO();
			market_TotalDTO.setNum(rs.getInt("num"));
			market_TotalDTO.setTitle(rs.getString("title"));
			market_TotalDTO.setWriter(rs.getString("writer"));
			market_TotalDTO.setCompany(rs.getString("company"));
			market_TotalDTO.setPublish_date(rs.getDate("publish_date"));
			market_TotalDTO.setLibrary(rs.getInt("library"));
			market_TotalDTO.setPrice(rs.getInt("price"));
			market_TotalDTO.setId(rs.getString("id"));
			market_TotalDTO.setWish(rs.getInt("wish"));
			market_TotalDTO.setApproval(rs.getInt("approval"));
			market_TotalDTO.setBook_state(rs.getInt("book_state"));
		}
		DBConnector.disConnect(rs, st, con);
		return market_TotalDTO;
	}
}
