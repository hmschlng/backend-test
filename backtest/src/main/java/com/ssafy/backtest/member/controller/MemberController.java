package com.ssafy.backtest.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.backtest.member.model.service.MemberService;

@RestController
@CrossOrigin
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
}
