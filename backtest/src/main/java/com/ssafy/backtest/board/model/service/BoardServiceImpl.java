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
	public List<Board> listArticle(Map<String, Object> params) throws Exception {
		int start = (int)params.get("pgno") == 1 ? 0 : (int)params.get("pgno") - 1 * (int)params.get("pageSize");
		params.put("start", start);
		List<Board> list = sqlSession.getMapper(BoardMapper.class).listArticle(params);
		return list;
	}
	
	@Override
	public Board getArticle(String category, int no) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category", category);
		map.put("articleNo", no);
		return sqlSession.getMapper(BoardMapper.class).getArticle(map);
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
	public boolean deleteArticle(String category, int no) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category", category);
		map.put("articleNo", no);
		return sqlSession.getMapper(BoardMapper.class).deleteArticle(map);
	}
	
}
