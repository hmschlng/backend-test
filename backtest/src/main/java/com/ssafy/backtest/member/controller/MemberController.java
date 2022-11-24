package com.ssafy.backtest.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.backtest.member.model.service.MemberService;
import com.ssafy.backtest.member.model.dto.Member;

@RestController
@CrossOrigin
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	/**
	 * 로그인
	 * 아이디와 비밀번호를 비교해 일치하면 jwt 토큰을 반환합니다.
	 * @param member
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<?> login(
			@RequestBody Member member,
			HttpSession session
			) throws Exception {
		return new ResponseEntity<>(memberService.loginMember(member), HttpStatus.OK);
	}
	
	/**
	 * 회원가입
	 * 사용자로부터 받은 회원 정보를 받아 DB에 저장합니다. 비밀번호는 SHA-256 해시코드로 인코딩해 저장합니다.
	 * @param member
	 * @return true if data successfully inserted to DB, false if failed
	 * @throws Exception
	 */
	@PostMapping("/join")
	public ResponseEntity<?> join(@RequestBody Member member) throws Exception {
		return new ResponseEntity<>(memberService.joinMember(member), HttpStatus.OK);
	}
	
	/**
	 * 아이디 유효성검사
	 * 회원가입 시 사용자가 입력한 이메일 아이디가 유효한지 검사합니다. 아이디는 고유해야 하며, 유효한 이메일이어야 합니다.
	 * 아이디가 고유한 이메일 주소라면, 해당 이메일 주소로 인증 메일을 보내고 인증 번호를 반환합니다.
	 * @param member
	 * @return String of 6-digit authentication number when the email id is unique, null if email id is duplicated
	 * @throws Exception
	 */
	@PostMapping("check")
	public ResponseEntity<?> checkEmailId(@RequestBody Member member) throws Exception {
		String code = memberService.checkEmailId(member);
		return new ResponseEntity<String>(code, HttpStatus.OK);
	}
	
	/**
	 * 비밀번호 찾기
	 * 사용자의 비밀번호를 찾기 위해 사용자의 이메일이 가입된 이메일인지 확인합니다.
	 * 가입된 이메일 아이디라면 해당 이메일 주소로 새로운 임시 비밀번호를 보내고 비밀번호를 임시 비밀번호로 변경합니다.
	 * @param emailId
	 * @return true if email id exists, false if not
	 * @throws Exception
	 */
	@GetMapping("{emailId}")
	public ResponseEntity<?> searchPw(
			@PathVariable String emailId
			) throws Exception {
		return new ResponseEntity<Boolean>(memberService.searchPw(emailId), HttpStatus.OK);
	}
	
	/**
	 * 비밀번호 변경
	 * 사용자의 비밀번호를 변경합니다. 비밀번호는 SHA-256 해시코드로 인코딩되어 저장됩니다. 
	 * @param member
	 * @return true if data successfully updated, false if failed
	 * @throws Exception
	 */
	@PutMapping("pass")
	public ResponseEntity<?> updatePass(
			@RequestBody Member member
			) throws Exception {
		return new ResponseEntity<>(memberService.updatePass(member), HttpStatus.OK);
	}
	
	/**
	 * 회원정보 변경
	 * 사용자의 회원정보를 변경합니다. 이름, 닉네임, 연락처, 프로필 사진 등을 변경합니다. 
	 * @param member
	 * @return true if data successfully updated, false if failed
	 * @throws Exception
	 */
	@PutMapping("update")
	public ResponseEntity<?> updateMember(
			@RequestBody Member member
			) throws Exception {
		return new ResponseEntity<>(memberService.updateMember(member), HttpStatus.OK);
	}
	
	/**
	 * 회원 탈퇴
	 * 회원 탈퇴를 위해 회원 정보를 삭제합니다.
	 * @param member
	 * @return true if data successfully deleted, false id failed
	 * @throws Exception
	 */
	@DeleteMapping("delete")
	public ResponseEntity<?> quit(
			@RequestBody Member member
			) throws Exception {
		return new ResponseEntity<>(memberService.quit(member), HttpStatus.OK);
	}
	
}
