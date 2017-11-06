package com.fnw.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.member.MemberDTO;
import com.fnw.util.DBConnector;
import com.fnw.util.MakeRow;

public class QnaDAO {
	public int getTotalCount() throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select nvl(count(num),0) from qna";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		int result = 0;
		if(rs.next()) {
			result = rs.getInt(1);
		}
		
		DBConnector.disConnect(rs, st, con);
		return result;
	}
	
	public ArrayList<QnaDTO> selectList(MakeRow makeRow) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql ="select * from "
				+ "(select rownum R, M.* from qna M order by num asc) "
				+ "where R between ? and ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, makeRow.getStartRow());
		st.setInt(2, makeRow.getLastRow());
		
		ResultSet rs = st.executeQuery();

		ArrayList<QnaDTO> ar = new ArrayList<>();
		QnaDTO qnaDTO = null;
		while(rs.next()) {
			qnaDTO = new QnaDTO();
			qnaDTO.setNum(rs.getInt("num"));
			qnaDTO.setType(rs.getInt("type"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setWriter(rs.getString("writer"));
			qnaDTO.setContents(rs.getString("contents"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setHit(rs.getInt("hit"));
			qnaDTO.setPw(rs.getString("pw"));
			qnaDTO.setKind(rs.getInt("kind"));
			ar.add(qnaDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
	public QnaDTO selectOne(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from qna where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);

		ResultSet rs = st.executeQuery();

		QnaDTO qnaDTO = null;
		while(rs.next()) {
			qnaDTO = new QnaDTO();
			qnaDTO.setNum(rs.getInt("num"));
			qnaDTO.setType(rs.getInt("type"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setWriter(rs.getString("writer"));
			qnaDTO.setContents(rs.getString("contents"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setHit(rs.getInt("hit"));
			qnaDTO.setPw(rs.getString("pw"));
			qnaDTO.setKind(rs.getInt("kind"));
		}
		DBConnector.disConnect(rs, st, con);
		return qnaDTO;
	}
	public QnaDTO pwCheck(int num,String pw) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "select * from qna where num=? and pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		st.setString(2, pw);

		ResultSet rs = st.executeQuery();

		QnaDTO qnaDTO = null;
		while(rs.next()) {
			qnaDTO = new QnaDTO();
			qnaDTO.setNum(rs.getInt("num"));
			qnaDTO.setType(rs.getInt("type"));
			qnaDTO.setTitle(rs.getString("title"));
			qnaDTO.setWriter(rs.getString("writer"));
			qnaDTO.setContents(rs.getString("contents"));
			qnaDTO.setReg_date(rs.getDate("reg_date"));
			qnaDTO.setHit(rs.getInt("hit"));
			qnaDTO.setPw(rs.getString("pw"));
			qnaDTO.setKind(rs.getInt("kind"));
		}
		DBConnector.disConnect(rs, st, con);
		return qnaDTO;
	}
	public int delete(int num) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "delete from qna where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		int result = st.executeUpdate();
		
		return result;
	}
	public int update(QnaDTO qnaDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		String sql="UPDATE qna SET type=?, title=?, contents=?, kind=? WHERE num=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, qnaDTO.getType());
		st.setString(2, qnaDTO.getTitle());
		st.setString(3, qnaDTO.getContents());
		st.setInt(4, qnaDTO.getKind());
		st.setInt(5, qnaDTO.getNum());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
}
