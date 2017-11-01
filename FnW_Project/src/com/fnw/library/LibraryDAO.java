package com.fnw.library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.util.DBConnector;

public class LibraryDAO {
	public void insert() {}
	public void delete() {}
	public void update() {}
	public void selectOne() {}
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
	}//
}
