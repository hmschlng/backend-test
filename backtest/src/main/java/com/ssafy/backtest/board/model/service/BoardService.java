package com.ssafy.backtest.board.model.service;

import com.ssafy.backtest.board.model.dto.Board;

public interface BoardService {
	
	Board getArticle(String category, int no) throws Exception;
	boolean writeArticle(Board board) throws Exception;
	boolean modifyArticle(Board board) throws Exception;
	boolean updateHit(Board board) throws Exception;
	boolean updateLike(Board board) throws Exception;
	boolean deleteArticle(String category, int no) throws Exception;
	
}
