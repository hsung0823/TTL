package com.fnw.market;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fnw.util.DBConnector;

public class Market_OrderDAO {
	
	public int insert(Market_OrderDTO market_OrderDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "insert into market_order values((select nvl(max(num),0) from market_order)+1,?,?,?,?,?,?,?)";
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
	public void delete() {}
	public void update() {}
	public void getTotalCount() {}
	public void selectOne() {}
	public void selectList() {}
}
