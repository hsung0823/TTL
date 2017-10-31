package com.fnw.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

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
			memberDTO.setLibrary(rs.getInt("library"));
			memberDTO.setKind(rs.getInt("kind"));
		}
		DBConnector.disConnect(rs, st, con);
		return memberDTO;
	}
	public MemberDTO selectOne(String id,String pw) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "SELECT * FROM member WHERE id=? and pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, pw);
		
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
			memberDTO.setLibrary(rs.getInt("library"));
			memberDTO.setKind(rs.getInt("kind"));
		}
		DBConnector.disConnect(rs, st, con);
		return memberDTO;
	}
	public int update(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql="UPDATE member SET pw=?, birth=?, addr=?, phone=?, email=?, library=? WHERE id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		System.out.println(memberDTO.getPw());
		st.setString(1, memberDTO.getPw());
		st.setDate(2, memberDTO.getBirth());
		st.setString(3, memberDTO.getAddr());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		st.setInt(6, memberDTO.getLibrary());
		st.setString(7, memberDTO.getId());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
}
