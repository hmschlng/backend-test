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
	String emailId;
	String pass;
	String name;
	String nickname;
	String phoneNumber;
	String imgOrigin;
	String imgSave;
	String joinDate;
	String exitDate;
	String lastLoginDate;
	String Status;
	String isAdmin;
}
