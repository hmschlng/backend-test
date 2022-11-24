package com.ssafy.backtest.board.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.backtest.board.model.dto.Board;
import com.ssafy.backtest.board.model.dto.BoardParam;

public interface BoardService {
	
	List<Board> listArticle(BoardParam boardParam) throws Exception;
	int countArticle(BoardParam boardParam) throws Exception;
	Board getArticle(int no) throws Exception;
	boolean writeArticle(Board board) throws Exception;
	boolean modifyArticle(Board board) throws Exception;
	boolean updateHit(Board board) throws Exception;
	boolean updateLike(Board board) throws Exception;
	boolean deleteArticle(int no) throws Exception;
	
}
