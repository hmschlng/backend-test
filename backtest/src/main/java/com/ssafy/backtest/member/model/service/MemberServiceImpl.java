package com.ssafy.backtest.member.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.backtest.member.model.dto.Member;
import com.ssafy.backtest.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Member getMember(String emailId) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).selectMember(emailId);
	}

}
