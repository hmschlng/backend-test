package com.ssafy.backtest.house.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.backtest.house.model.dto.AreaCode;

@Mapper
public interface HouseMapper {

	public List<AreaCode> getSidoList() throws SQLException;

	public List<AreaCode> getGugunList(String sidoCode) throws SQLException;

	public List<AreaCode> getDongList(String gugunCode) throws SQLException;

}
