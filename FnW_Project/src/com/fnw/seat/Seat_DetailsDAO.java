package com.fnw.seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.util.DBConnector;

public class Seat_DetailsDAO {
	public ArrayList<Seat_DetailsDTO> selectList(String id) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql="select * from seat_details where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();

		ArrayList<Seat_DetailsDTO> ar = new ArrayList<>();
		Seat_DetailsDTO seat_DetailsDTO = null;
		while(rs.next()) {
			seat_DetailsDTO = new Seat_DetailsDTO();
			seat_DetailsDTO.setNum(rs.getInt("num"));
			seat_DetailsDTO.setSeat_num(rs.getInt("seat_num"));
			seat_DetailsDTO.setLibrary(rs.getInt("library"));
			seat_DetailsDTO.setId(rs.getString("id"));
			seat_DetailsDTO.setIn_time(rs.getDate("in_time"));
			seat_DetailsDTO.setOut_time(rs.getDate("out_time"));
			seat_DetailsDTO.setState(rs.getInt("state"));
			
			ar.add(seat_DetailsDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
}
