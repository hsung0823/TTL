package com.fnw.seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.util.DBConnector;

public class SeatDAO {
	public ArrayList<SeatDTO> selectList(int library) throws Exception{
		 Connection con = DBConnector.getConnect();
		 String sql = "select * from seat where library=? ";
		 PreparedStatement st = con.prepareStatement(sql);
		 st.setInt(1, library);
		 
		 ResultSet rs = st.executeQuery();
		 
		 ArrayList<SeatDTO> ar = new ArrayList<>();
		 
		 while(rs.next()) {
			 SeatDTO seatDTO = new SeatDTO();
			 seatDTO.setSeat_num(rs.getInt("seat_num"));
			 seatDTO.setLibrary(rs.getInt("library"));
			 seatDTO.setState(rs.getInt("state"));
			 seatDTO.setId(rs.getString("id"));
			 seatDTO.setReserve_time(rs.getDate("reserve_time"));
			 ar.add(seatDTO);
		 }
		 
		 DBConnector.disConnect(rs, st, con);
		 
		 return ar;
				 
	}
}
