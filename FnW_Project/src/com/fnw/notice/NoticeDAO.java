package com.fnw.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fnw.util.DBConnector;
import com.fnw.util.MakeRow;

public class NoticeDAO {
	public int insert(NoticeDTO noticeDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql ="insert into notice values(notice_seq.nextval,?,?,?,sysdate,0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getWriter());
		st.setString(3, noticeDTO.getContents());
		int result = st.executeUpdate();

		DBConnector.disConnect(st, con);

		return result;
	}
	public int update(NoticeDTO noticeDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql ="update notice set title=?, contents=? where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getContents());
		st.setInt(3, noticeDTO.getNum());
		int result = st.executeUpdate();
		
		
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	public int delete(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql ="delete notice where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	public int hitUpdate(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql ="update notice set hit=hit+1 where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		return result;
	}
	
	public int getTotalCount(String kind, String search) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select nvl(count(num), 0) from notice where "+kind+" like ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		
		DBConnector.disConnect(rs, st, con);
		return result;
	}
	
	public NoticeDTO selectOne(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		
		String sql ="select * from notice where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		NoticeDTO noticeDTO=null;
		
		if(rs.next()) {
			noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return noticeDTO;
		
	}

	public List<NoticeDTO> selectList(MakeRow makeRow, String kind, String search) throws Exception {
		Connection con = DBConnector.getConnect();

		List<NoticeDTO> ar = new ArrayList<>();

		String sql = "select * from "
				+ "(select rownum R, N.* from "
				+ "(select * from notice where " +kind +" like ? order by num desc) N)"
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		st.setInt(2, makeRow.getStartRow());
		st.setInt(3, makeRow.getLastRow());
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt("num"));
			noticeDTO.setTitle(rs.getString("title"));
			noticeDTO.setWriter(rs.getString("writer"));
			noticeDTO.setContents(rs.getString("contents"));
			noticeDTO.setReg_date(rs.getDate("reg_date"));
			noticeDTO.setHit(rs.getInt("hit"));
			ar.add(noticeDTO);
		}

		DBConnector.disConnect(rs, st, con);

		return ar;
	}
}
