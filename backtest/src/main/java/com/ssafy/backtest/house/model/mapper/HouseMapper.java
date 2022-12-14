package com.ssafy.backtest.house.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.backtest.house.model.dto.Apt;
import com.ssafy.backtest.house.model.dto.AreaCode;

@Mapper
public interface HouseMapper {

	public List<AreaCode> selectSidoList() throws SQLException;
	public List<AreaCode> selectGugunList(String sidoCode) throws SQLException;
	public List<AreaCode> selectDongList(String gugunCode) throws SQLException;
	public List<Apt> selectAptList(Map<String, String> map) throws SQLException;

}
