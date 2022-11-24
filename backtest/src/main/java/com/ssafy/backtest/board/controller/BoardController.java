package com.ssafy.backtest.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.backtest.board.model.dto.Board;
import com.ssafy.backtest.board.model.dto.BoardParam;
import com.ssafy.backtest.board.model.service.BoardService;

@RestController
@CrossOrigin
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public ResponseEntity<List<Board>> getBoardList(
			BoardParam boardParam
			) throws Exception {
		return new ResponseEntity<List<Board>>(boardService.listArticle(boardParam), HttpStatus.OK);
	}
	
	@GetMapping("count") 
	public ResponseEntity<?> countListSize(
			BoardParam boardParam
			) throws Exception {
		return new ResponseEntity<>(boardService.countArticle(boardParam), HttpStatus.OK);
	}
	
	@GetMapping("{no}")
	public ResponseEntity<Board> getArticle( 
			@PathVariable int no
			) throws Exception {
		return new ResponseEntity<Board>(boardService.getArticle(no), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> writeArticle(
			@RequestBody Board board
			) throws Exception {
		return new ResponseEntity<>(boardService.writeArticle(board), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> modifyArticle(
			@RequestBody Board board
			) throws Exception {
		return new ResponseEntity<>(boardService.modifyArticle(board), HttpStatus.OK);
	}
	
	@PutMapping("/hit")
	public ResponseEntity<?> updateHit(
			@RequestBody Board board
			) throws Exception {
		return new ResponseEntity<>(boardService.updateHit(board), HttpStatus.OK);
	}
	
	@PutMapping("/like")
	public ResponseEntity<?> updateLike(
			@RequestBody Board board
			) throws Exception {
		return new ResponseEntity<>(boardService.updateLike(board), HttpStatus.OK);
	}
	
	@DeleteMapping("{no}")
	public ResponseEntity<?> deleteArticle(
			@PathVariable int no
			) throws Exception {
		return new ResponseEntity<>(boardService.deleteArticle(no), HttpStatus.OK);
	}
	
	// 댓글 부분 구현 예정
}
