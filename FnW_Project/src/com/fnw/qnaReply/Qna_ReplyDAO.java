package com.fnw.qnaReply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fnw.qna.QnaDTO;
import com.fnw.util.DBConnector;

public class Qna_ReplyDAO {
	public int insert(Qna_ReplyDTO qna_ReplyDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		QnaDTO qnaDTO = new QnaDTO();
		String sql = "insert into qna_reply values(?,?,?,sysdate,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, qna_ReplyDTO.getNum());
		st.setString(2, qna_ReplyDTO.getWriter());
		st.setString(3, qna_ReplyDTO.getContents());
		st.setInt(4, qna_ReplyDTO.getRef());
		st.setInt(5, qna_ReplyDTO.getStep());
		st.setInt(6, qna_ReplyDTO.getDepth());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
	
	public ArrayList<Qna_ReplyDTO> selectList(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select * from qna_reply where ref=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();

		ArrayList<Qna_ReplyDTO> ar = new ArrayList<>();
		Qna_ReplyDTO qna_ReplyDTO = null;
		while(rs.next()) {
			qna_ReplyDTO = new Qna_ReplyDTO();
			qna_ReplyDTO.setNum(rs.getInt("num"));
			qna_ReplyDTO.setWriter(rs.getString("writer"));
			qna_ReplyDTO.setContents(rs.getString("contents"));
			qna_ReplyDTO.setReg_date(rs.getDate("reg_date"));
			qna_ReplyDTO.setRef(rs.getInt("ref"));
			qna_ReplyDTO.setStep(rs.getInt("step"));
			qna_ReplyDTO.setDepth(rs.getInt("depth"));
			ar.add(qna_ReplyDTO);
		}
		DBConnector.disConnect(rs, st, con);
		return ar;
	}
}
