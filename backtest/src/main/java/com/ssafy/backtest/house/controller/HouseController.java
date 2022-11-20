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
}
