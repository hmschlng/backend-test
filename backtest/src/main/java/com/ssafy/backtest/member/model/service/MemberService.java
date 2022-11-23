package com.ssafy.backtest.member.model.service;

import com.ssafy.backtest.member.model.dto.Member;

public interface MemberService {

	Member getMember(String emailId) throws Exception;

	boolean joinMember(Member member) throws Exception;

	String login(Member member) throws Exception;

	String checkEmailId(Member member) throws Exception;

	boolean searchPw(String emailId) throws Exception;

	boolean updatePw(Member member) throws Exception;

}
