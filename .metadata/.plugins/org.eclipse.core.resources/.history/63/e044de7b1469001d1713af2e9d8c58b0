package com.ssafy.backtest.house.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.backtest.house.model.dto.AreaCode;
import com.ssafy.backtest.house.model.mapper.HouseMapper;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<AreaCode> getSidoList() throws Exception {
		return sqlSession.getMapper(HouseMapper.class).getSidoList();
	}

	@Override
	public List<AreaCode> getGugunList(String sidoCode) throws Exception {
		return sqlSession.getMapper(HouseMapper.class).getGugunList(sidoCode);
	}

	@Override
	public List<AreaCode> getDongList(String gugunCode) throws Exception {
		return sqlSession.getMapper(HouseMapper.class).getDongList(gugunCode);
	}

}
