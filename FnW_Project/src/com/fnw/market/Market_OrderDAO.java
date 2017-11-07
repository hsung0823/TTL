package com.fnw.market;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fnw.util.DBConnector;
import com.fnw.util.MakeRow;

public class Market_OrderDAO {
	
	public int insert(Market_OrderDTO market_OrderDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "insert into market_order values((select nvl(max(num),0) from market_order)+1,?,?,?,?,?,?,?,1)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, market_OrderDTO.getTitle());
		st.setString(2, market_OrderDTO.getWriter());
		st.setString(3, market_OrderDTO.getCompany());
		st.setString(4, market_OrderDTO.getPublish_date());
		st.setInt(5, market_OrderDTO.getPrice());
		st.setString(6, market_OrderDTO.getId());
		st.setInt(7, market_OrderDTO.getLibrary());

		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	public  int delete(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql ="delete market_order where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		
		return result;
	}
	public int update(Market_OrderDTO market_OrderDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql ="update market_order set title=?, writer=?, company=?, publish_date=?, price=?, library=? where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, market_OrderDTO.getTitle());
		st.setString(2, market_OrderDTO.getWriter());
		st.setString(3, market_OrderDTO.getCompany());
		st.setString(4, market_OrderDTO.getPublish_date());
		st.setInt(5, market_OrderDTO.getPrice());
		st.setInt(6, market_OrderDTO.getLibrary());
		st.setInt(7, market_OrderDTO.getNum());
		
		int result = st.executeUpdate();
		
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	public int getTotalCount(String kind, String search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select nvl(count(num), 0) from market_order where "+kind+" like ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		
		DBConnector.disConnect(rs, st, con);
		return result;
	}
	
	public Market_OrderDTO selectOne(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		
		String sql ="select * from market_order where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		Market_OrderDTO market_OrderDTO=null;
		
		if(rs.next()) {
			market_OrderDTO = new Market_OrderDTO();
			market_OrderDTO.setNum(rs.getInt("num"));
			market_OrderDTO.setTitle(rs.getString("title"));
			market_OrderDTO.setWriter(rs.getString("writer"));
			market_OrderDTO.setCompany(rs.getString("company"));
			market_OrderDTO.setPublish_date(rs.getString("publish_date"));
			market_OrderDTO.setPrice(rs.getInt("price"));
			market_OrderDTO.setId(rs.getString("id"));
			market_OrderDTO.setLibrary(rs.getInt("library"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return market_OrderDTO;
		
	}
	
	public List<Market_OrderDTO> selectList(MakeRow makeRow, String kind, String search) throws Exception {
		Connection con = DBConnector.getConnect();

		List<Market_OrderDTO> ar = new ArrayList<>();

		String sql = "select * from "
				+ "(select rownum R, N.* from "
				+ "(select * from market_order where " +kind +" like ? order by num desc) N)"
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		st.setInt(2, makeRow.getStartRow());
		st.setInt(3, makeRow.getLastRow());
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			Market_OrderDTO market_OrderDTO = new Market_OrderDTO();
			market_OrderDTO.setNum(rs.getInt("num"));
			market_OrderDTO.setTitle(rs.getString("title"));
			market_OrderDTO.setWriter(rs.getString("writer"));
			market_OrderDTO.setCompany(rs.getString("company"));
			market_OrderDTO.setPublish_date(rs.getString("publish_date"));
			market_OrderDTO.setPrice(rs.getInt("price"));
			market_OrderDTO.setId(rs.getString("id"));
			market_OrderDTO.setLibrary(rs.getInt("library"));
			ar.add(market_OrderDTO);
		}

		DBConnector.disConnect(rs, st, con);

		return ar;
	}
}
