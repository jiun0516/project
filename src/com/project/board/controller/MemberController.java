package com.project.board.controller;

import com.project.board.dto.MemberDTO;
import com.project.board.service.MemberService;

public class MemberController {
	
	private MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
	}
	
	public String memberDTO(MemberDTO memberDTO) {
		String member = memberService.insert(memberDTO);
		return member;
	}

}
