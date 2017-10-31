package com.fnw.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fnw.util.DBConnector;

public class MemberDAO {
	public MemberDTO selectOne(String id) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "SELECT * FROM member WHERE id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		MemberDTO memberDTO = null;
		if(rs.next()) {
			memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString("id"));
			memberDTO.setPw(rs.getString("pw"));
			memberDTO.setName(rs.getString("name"));
			memberDTO.setBirth(rs.getDate("birth"));
			memberDTO.setGender(rs.getString("gender"));
			memberDTO.setAddr(rs.getString("addr"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));
			memberDTO.setLibrary(rs.getString("library"));
			memberDTO.setKind(rs.getInt("kind"));
		}
		return memberDTO;
	}
	public int selectOne(String id,String pw) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "SELECT * FROM member WHERE id=? and pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, pw);
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
}
