package com.ssafy.backtest.house.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apt {
	// houseinfo 컬럼
	long aptCode;
	int buildYear;
	String roadName;
	String roadNameBonbun;
	String roadNameBubun;
	String roadNameSeq;
	String roadNameBasementCode;
	String roadNameCode;
	String dong;
	String bonbun;
	String bubun;
	String sigunguCode;
	String eubmyundongCode;
	String dongCode;
	String landCode;
	String apartmentName;
	String jibun;
	String lng;
	String lat;

	// housedeal 컬럼
	long no;
	String dealAmount;
	int dealYear;
	int dealMonth;
	int dealDay;
	String area;
	String floor;
	String cancelDealType;
}
