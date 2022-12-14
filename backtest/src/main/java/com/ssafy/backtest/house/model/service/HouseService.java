package com.ssafy.backtest.house.model.service;

import java.util.List;

import com.ssafy.backtest.house.model.dto.Apt;
import com.ssafy.backtest.house.model.dto.AreaCode;

public interface HouseService {

	List<AreaCode> getSidoList() throws Exception;
	List<AreaCode> getGugunList(String sidoCode) throws Exception;
	List<AreaCode> getDongList(String gugunCode) throws Exception;
	List<Apt> getAptList(String areaCode, String dealYm) throws Exception;

}
