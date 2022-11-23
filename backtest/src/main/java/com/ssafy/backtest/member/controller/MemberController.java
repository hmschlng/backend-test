package com.ssafy.backtest.member.controller;

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

import com.ssafy.backtest.member.model.dto.Member;
import com.ssafy.backtest.member.model.service.MemberService;
import com.ssafy.backtest.util.MailService;

@RestController
@CrossOrigin
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MailService mailService;
//	
//	@GetMapping("/logout")
//	public ResponseEntity<String> logout() throws Exception {
//		return null;
//	}
//	
//	@PostMapping("/login")
//	public ResponseEntity<String> login(
//			@RequestBody Member member
//			) throws Exception {
//		return null;
//	}
//	

//	
//	@PutMapping("/update")
//	public ResponseEntity<String> updateMember(
//			@RequestBody Member member
//			) throws Exception {
//		return null;
//	}
//	
//	@DeleteMapping("/{emailId}")
//	public ResponseEntity<String> deleteMember(
//			) throws Exception {
//		return null;
//	}
	

	
	@PostMapping("/join")
	public ResponseEntity<?> join(@RequestBody Member member) throws Exception {
		return new ResponseEntity<>(memberService.joinMember(member), HttpStatus.OK);
	}
	
	@PostMapping("check")
	public ResponseEntity<?> checkEmailId(@RequestBody Member member) throws Exception {
		return new ResponseEntity<String>(memberService.checkEmailId(member), HttpStatus.OK);
	}
	
	@GetMapping("pw")
	public ResponseEntity<?> searchPw(
			@PathVariable String emailId
			) throws Exception {
		return new ResponseEntity<Boolean>(memberService.searchPw(emailId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> login(
			@RequestBody Member member
			) throws Exception {
		return ResponseEntity.ok().body(memberService.login(member));
	}
	
	@PutMapping("updatePw")
	public ResponseEntity<?> updatePw(
			@RequestBody Member member
			) throws Exception {
		return ResponseEntity.ok().body(memberService.updatePw(member));
	}
	
}
