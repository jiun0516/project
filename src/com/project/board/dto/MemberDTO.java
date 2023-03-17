package com.project.board.dto;

import java.sql.Timestamp;

public class MemberDTO {

	private String user_id;
	private String user_pw;
	private String user_name;
	private String email;
	private Timestamp regdate;

	public MemberDTO() {

	}

	public MemberDTO(String user_id, String user_pw, String user_name, String email, Timestamp regdate) {
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.email = email;
		this.regdate = regdate;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberDTO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + ", email="
				+ email + ", regdate=" + regdate + "]";
	}

}
