package com.fnw.qnaReply;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.fnw.qna.QnaDTO;
import com.fnw.util.DBConnector;

public class Qna_ReplyDAO {
	public int insert(Qna_ReplyDTO qna_ReplyDTO) throws Exception{
		Connection con = DBConnector.getConnect();
		QnaDTO qnaDTO = new QnaDTO();
		String sql = "insert into qna_reply values(?,?,?,sysdate,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, qna_ReplyDTO.getNum());
		st.setString(2, qna_ReplyDTO.getWirter());
		st.setString(3, qna_ReplyDTO.getContents());
		st.setInt(4, qna_ReplyDTO.getRef());
		st.setInt(5, qna_ReplyDTO.getStep());
		st.setInt(6, qna_ReplyDTO.getDepth());
		
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}
}
