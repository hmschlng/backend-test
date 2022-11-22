package com.ssafy.backtest.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.backtest.board.model.dto.Board;
import com.ssafy.backtest.board.model.dto.BoardParam;

@Mapper
public interface BoardMapper {

	List<Board> listArticle(Map<String, Object> params) throws SQLException;
	Board getArticle(Map<String, Object> map) throws SQLException;
	int writeArticle(Board board) throws SQLException;
	int modifyArticle(Board board) throws SQLException;
	int updateHit(Board board) throws SQLException;
	int updateLike(Board board) throws SQLException;
	boolean deleteArticle(Map<String, Object> map) throws SQLException;

}
