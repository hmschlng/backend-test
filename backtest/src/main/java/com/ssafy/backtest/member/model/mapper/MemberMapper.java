package com.ssafy.backtest.member.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.backtest.member.model.dto.Member;

@Mapper
public interface MemberMapper {

	Member selectMember(String emailId) throws SQLException;

	boolean insertMember(Member member) throws SQLException;

	int updatePw(String pass) throws SQLException;

}
