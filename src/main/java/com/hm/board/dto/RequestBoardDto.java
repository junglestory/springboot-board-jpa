package com.hm.board.dto;

import com.hm.board.entity.Board;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestBoardDto {
	private Long boardNo;
	private String title;
	private String contents;
	private String writer;
	private Integer viewCount;
		
	public Board toSaveEntity() {
		return Board.builder()
				.title(title)
				.contents(contents)
				.writer(writer)
				.build();
	}
	
	public Board toUpdateEntity() {
		return Board.builder()
				.boardNo(boardNo)
				.title(title)
				.contents(contents)
				.writer(writer)
				.viewCount(viewCount)
				.build();
	}
}
