package com.ssafy.backtest.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.backtest.house.model.dto.Apt;
import com.ssafy.backtest.house.model.dto.AreaCode;
import com.ssafy.backtest.house.model.service.HouseService;

@RestController
@CrossOrigin
@RequestMapping("/house")
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	@GetMapping("/sido")
	public ResponseEntity<List<AreaCode>> getSido() throws Exception {
		return new ResponseEntity<List<AreaCode>>(houseService.getSidoList(), HttpStatus.OK);
	}
	
	@GetMapping("/gugun/{sidoCode}")
	public ResponseEntity<List<AreaCode>> getGugun(
			@PathVariable String sidoCode) throws Exception {
		return new ResponseEntity<List<AreaCode>>(houseService.getGugunList(sidoCode), HttpStatus.OK);
	}
	
	@GetMapping("/dong/{gugunCode}")
	public ResponseEntity<List<AreaCode>> getDong(
			@PathVariable String gugunCode) throws Exception {
		return new ResponseEntity<List<AreaCode>>(houseService.getDongList(gugunCode), HttpStatus.OK);
	}
	
	/**
	 * 지역과 날짜 조건에 맞는 아파트 매물에 대한 상세 정보를 return한다.
	 * 
	 * Parameter
	 * 	code : 시도/구군/읍면동 정보를 포함한 10자리 String
	 * 	date : YYYYMM 형태의 6자리 날짜 String
	 * 
	 * Returns
	 * 	아파트 정보가 담긴 JSON 포맷의 String
	*/
	@GetMapping("/apt/{areaCode}/{dealYm}")
	public ResponseEntity<List<Apt>> getAptList(
			@PathVariable("areaCode") String areaCode, @PathVariable("dealYm") String dealYm) throws Exception {
		return new ResponseEntity<List<Apt>>(houseService.getAptList(areaCode, dealYm), HttpStatus.OK);
	}
}
