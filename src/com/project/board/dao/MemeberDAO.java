package com.project.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.board.dto.MemberDTO;
import com.project.board.utils.DBHelper;

public class MemeberDAO implements IMemberDAO {

	private DBHelper dbHelper;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MemeberDAO() {
		DBHelper dbHelper = new DBHelper();
		conn = dbHelper.getConnection();
	}
	private static MemeberDAO instance = new MemeberDAO();
	public static MemeberDAO getInstance() {
		return instance;
	}
		

	// 사용자 정보 저장
	@Override
	public int insertMember(MemberDTO memberDTO) {
		int resultRow = 0;

		String sql = " INSERT INTO member(user_id, user_pw, user_name, email, regdate) "
				+ " VALUES (?, ?, ?, ?, now()) ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getUser_id());
			pstmt.setString(2, memberDTO.getUser_pw());
			pstmt.setString(3, memberDTO.getUser_name());
			pstmt.setString(4, memberDTO.getEmail());
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" >> insert 에서 에러 발생 << ");
			e.printStackTrace();
		}

		return resultRow;
	}


	@Override
	public int selectUserByUsernameAndPassword(String user_name, String user_pw) {
		MemberDTO resultMember = null;
		
		String query = " SELECT * "
				+ " FROM member "
				+ " WHERE user_name = ? "
				+ "	AND user_pw = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user_name);
			pstmt.setString(2, user_pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
