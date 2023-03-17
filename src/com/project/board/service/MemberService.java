package com.project.board.service;

import com.project.board.dao.MemeberDAO;
import com.project.board.dto.MemberDTO;

public class MemberService {
	
	private MemeberDAO memeberDAO;
	
	public MemberService() {
		memeberDAO = MemeberDAO.getInstance();
	}
	
	public String insert(MemberDTO memberDTO) {
		String insertMsg = "";
		if(memberDTO.getUser_id().equals(insertMsg)) {
			int resultRow = memeberDAO.insertMember(memberDTO);
			return resultRow + "";
		}
		return insertMsg;
	}
	
}
