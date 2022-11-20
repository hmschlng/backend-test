package com.ssafy.backtest.house.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.backtest.house.model.dto.Apt;
import com.ssafy.backtest.house.model.dto.AreaCode;
import com.ssafy.backtest.house.model.mapper.HouseMapper;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<AreaCode> getSidoList() throws Exception {
		return sqlSession.getMapper(HouseMapper.class).selectSidoList();
	}

	@Override
	public List<AreaCode> getGugunList(String sidoCode) throws Exception {
		return sqlSession.getMapper(HouseMapper.class).selectGugunList(sidoCode);
	}

	@Override
	public List<AreaCode> getDongList(String gugunCode) throws Exception {
		return sqlSession.getMapper(HouseMapper.class).selectDongList(gugunCode);
	}

	@Override
	public List<Apt> getAptList(String areaCode, String dealYm) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("areaCode", areaCode);
		map.put("year", dealYm.substring(0, 4));
		map.put("month", dealYm.substring(4));
		
		return sqlSession.getMapper(HouseMapper.class).selectAptList(map);
	}

}
