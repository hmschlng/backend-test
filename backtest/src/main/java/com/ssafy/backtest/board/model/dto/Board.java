package com.ssafy.backtest.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	int articleNo;
	String category;
	String memberId;
	String nickname;
	String title;
	String content;
	int hit;
	int like;
	String registerTime;
}
