package com.ssafy.backtest.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardParam {
	String category;
	int pgno;
	int pageSize;
	int start;
	String option;
	String keyword;
}
