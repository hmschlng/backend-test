package com.ssafy.backtest.member.model.service;

import com.ssafy.backtest.member.model.dto.Member;

public interface MemberService {

	Member getMember(String emailId) throws Exception;

}
