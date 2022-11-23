//package com.ssafy.backtest.member.model.service;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ssafy.backtest.member.model.dto.Member;
//import com.ssafy.backtest.member.model.mapper.MemberMapper;
//import com.ssafy.backtest.util.MailService;
//
//@Service
//public class MemberServiceImpl implements MemberService {
//
//	@Autowired
//	private SqlSession sqlSession;
//	
//	@Autowired
//	private MailService mailService;
//	
//	@Override
//	public Member getMember(String emailId) throws Exception {
//		return sqlSession.getMapper(MemberMapper.class).selectMember(emailId);
//	}
//	@Override
//	public boolean joinMember(Member member) throws Exception {
//		return sqlSession.getMapper(MemberMapper.class).insertMember(member);
//	}
//	
//	@Override
//	public String login(Member member) throws Exception {
//		return null; 
//	}
//	
//	@Override
//	public String checkEmailId(Member member) throws Exception {
//		if(getMember(member.getEmailId()) == null) {
//			return mailService.sendAuthMail(member.getEmailId());
//		}
//		return null;
//	}
//	
//	/** 
//	 * 존재하는 아이디면 임시 비밀번호를 담은 메일을 전송하고 임시 비밀번호로 비밀번호를 바꾸기
//	 */
//	@Override
//	@Transactional
//	public boolean searchPw(String emailId) throws Exception {
//		Member member = getMember(emailId);
//		if(member != null) {
//			String tempPw = mailService.sendPassChangeMail(emailId);
//			member.setPass(tempPw);
//			return updatePw(member);
//		}
//		return false;
//	}
//	
//	@Override
//	public boolean updatePw(Member member) throws Exception {
//		return sqlSession.getMapper(MemberMapper.class).updatePw(member.getPass()) == 1;
//	}
//}
