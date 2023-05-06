package com.hm.board.dto;

import com.hm.board.entity.Board;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestBoardDto {
	private int boardNo;
	private String title;
	private String contents;
	private String writer;
		
	public Board toEntity() {
		return Board.builder()
				.boardNo(boardNo)
				.title(title)
				.contents(contents)
				.writer(writer)
				.build();
	}
}
