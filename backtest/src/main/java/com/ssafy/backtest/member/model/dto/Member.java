package com.ssafy.backtest.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String emailId;
	private String pass;
	private String name;
	private String nickname;
	private String phoneNumber;
	private String imgOrigin;
	private String imgSave;
	private String joinDate;
	private String exitDate;
	private String lastLoginDate;
	private String Status;
	private String isAdmin;
	private String token;
}
