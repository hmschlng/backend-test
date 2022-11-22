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
	
	@GetMapping("/{category}/{pgno}/{pageSize}/{option}/{keyword}")
	public ResponseEntity<List<Board>> getBoardList(
			@PathVariable String category,
			@PathVariable int pgno,
			@PathVariable int pageSize,
			@PathVariable String option,
			@PathVariable String keyword
			) throws Exception {
		
		Map<String, Object> params = new HashMap<>();
		
		params.put("category", category);
		params.put("pgno", pgno);
		params.put("pageSize", pageSize);
		params.put("option", option);
		params.put("keyword", keyword);
		return new ResponseEntity<List<Board>>(boardService.listArticle(params), HttpStatus.OK);
	}
	
	@GetMapping("/view/{category}/{no}")
	public ResponseEntity<Board> getArticle(
			@PathVariable String category, 
			@PathVariable int no
			) throws Exception {
		return new ResponseEntity<Board>(boardService.getArticle(category, no), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> writeArticle(
			@RequestBody Board board
			) throws Exception {
		if (boardService.writeArticle(board)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<String> modifyArticle(
			@RequestBody Board board
			) throws Exception {
		if (boardService.modifyArticle(board)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/hit")
	public ResponseEntity<String> updateHit(
			@RequestBody Board board
			) throws Exception {
		if (boardService.updateHit(board)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/like")
	public ResponseEntity<String> updateLike(
			@RequestBody Board board
			) throws Exception {
		if (boardService.updateLike(board)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{category}/{no}")
	public ResponseEntity<String> deleteArticle(
			@PathVariable String category,
			@PathVariable int no
			) throws Exception {
		if(boardService.deleteArticle(category, no)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
	}
	
}
