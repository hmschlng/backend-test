package com.ssafy.backtest.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.backtest.board.model.dto.Board;
import com.ssafy.backtest.board.model.dto.BoardParam;
import com.ssafy.backtest.board.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Board> listArticle(BoardParam boardParam) throws Exception {
		int start = boardParam.getPgno() == 1 ? 0 : (boardParam.getPgno() - 1) * boardParam.getPageSize();
		boardParam.setStart(start);
		return sqlSession.getMapper(BoardMapper.class).listArticle(boardParam);
	}
	
	@Override
	public int countArticle(BoardParam boardParam) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).countArticle(boardParam);
	}
	
	@Override
	public Board getArticle(int no) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).getArticle(no);
	}

	@Override
	public boolean writeArticle(Board board) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).writeArticle(board) == 1;
	}

	@Override
	@Transactional
	public boolean modifyArticle(Board board) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).modifyArticle(board) == 1;
	}

	@Override
	@Transactional
	public boolean updateHit(Board board) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).updateHit(board) == 1;
	}

	@Override
	@Transactional
	public boolean updateLike(Board board) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).updateLike(board) == 1;
	}
	
	@Override
	@Transactional
	public boolean deleteArticle(int no) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).deleteArticle(no) == 1;
	}
	
}
