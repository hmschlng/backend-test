package com.ssafy.backtest.member.model.service;

import com.ssafy.backtest.member.model.dto.Member;

public interface MemberService {

	Member getMember(String emailId) throws Exception;
	boolean joinMember(Member member) throws Exception;
	Member loginMember(Member member) throws Exception;
	String checkEmailId(Member member) throws Exception;
	boolean searchPw(String emailId) throws Exception;
	boolean quit(Member member) throws Exception;
	boolean updatePass(Member member) throws Exception;
	boolean updateMember(Member member) throws Exception;

}
