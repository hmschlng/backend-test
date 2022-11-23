package com.ssafy.backtest.member.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.backtest.member.model.dto.Member;
import com.ssafy.backtest.member.model.mapper.MemberMapper;
import com.ssafy.backtest.member.util.JwtUtil;
import com.ssafy.backtest.member.util.MailDispatcher;
import com.ssafy.backtest.member.util.PasswordEncoder;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private MailDispatcher mailService;
	
	@Override
	public Member getMember(String emailId) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).selectMember(emailId);
	}
	@Override
	public boolean joinMember(Member member) throws Exception {
		member.setPass(PasswordEncoder.getSha256Hashcode(member.getPass()));
		return sqlSession.getMapper(MemberMapper.class).insertMember(member) == 1;
	}
	
	@Override
	public Member loginMember(Member member) throws Exception {
		if(member.getEmailId() == null || member.getPass() == null) return null;
		
		// 패스워드를 SHA-256 해시코드로 변환
		member.setPass(PasswordEncoder.getSha256Hashcode(member.getPass()));
		Member loginMember = sqlSession.getMapper(MemberMapper.class).loginMember(member);
		if(loginMember != null) {
			loginMember.setToken(JwtUtil.create(loginMember.getEmailId()));
			return loginMember;
		}
		return null;
	}
	
	@Override
	public String checkEmailId(Member member) throws Exception {
		if(getMember(member.getEmailId()) == null) {
			return mailService.sendAuthMail(member.getEmailId());
		}
		return null;
	}
	
	/** 
	 * 존재하는 아이디면 임시 비밀번호를 담은 메일을 전송하고 임시 비밀번호로 비밀번호를 바꾸기
	 */
	@Override
	@Transactional
	public boolean searchPw(String emailId) throws Exception {
		Member member = getMember(emailId);
		if(member != null) {
			String tempPw = mailService.sendPassChangeMail(emailId);
			member.setPass(tempPw);
			return sqlSession.getMapper(MemberMapper.class).updatePass(member.getEmailId(), member.getPass()) == 1;
		}
		return false;
	}
	
	@Override
	public boolean quit(Member member) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).deleteMember(member.getEmailId()) == 1; 
	}
	
	@Override
	public boolean updateMember(Member member) throws Exception {
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		String emailId = member.getEmailId();
		if(member.getPass() != null) {
			return mapper.updatePass(emailId, PasswordEncoder.getSha256Hashcode(member.getPass())) == 1;
		} else if(member.getNickname() != null) {
			return mapper.updateNickname(emailId, member.getNickname()) == 1;
		} else if(member.getPhoneNumber() != null) {
			return mapper.updatePhoneNumber(emailId, member.getPhoneNumber()) == 1;
		} //else if(member.getImgOrigin() != null) {
		else return false;
	}
		
}
