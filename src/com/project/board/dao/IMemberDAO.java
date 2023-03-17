package com.project.board.dao;

import com.project.board.dto.MemberDTO;

public interface IMemberDAO {
	
	int insertMember(MemberDTO memberDTO);
	int selectUserByUsernameAndPassword(String user_name, String user_pw);
	
}
