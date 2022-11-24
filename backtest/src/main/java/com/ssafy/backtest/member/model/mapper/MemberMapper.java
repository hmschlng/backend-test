package com.ssafy.backtest.member.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.backtest.member.model.dto.Member;

@Mapper
public interface MemberMapper {

	Member selectMember(String emailId) throws SQLException;
	int insertMember(Member member) throws SQLException;
	int deleteMember(String emailId) throws SQLException;
	Member loginMember(Member member) throws SQLException;
	int updatePass(String emailId, String pass) throws SQLException;
	int updateMember(Member member) throws SQLException;
	
}
