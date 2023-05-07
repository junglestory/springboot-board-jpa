package com.hm.board.dto;

import com.hm.board.entity.Board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestBoardDto {
	private int boardNo;
	private String title;
	private String contents;
	private String writer;
		
//	@Builder
//    public RequestBoardDto(int boardNo, String title, String contents, String writer){
//        this.boardNo = boardNo;
//        this.title = title;
//        this.contents = contents;
//        this.writer = writer;
//    }
//	
	public Board toEntity() {
		return Board.builder()
				.boardNo(boardNo)
				.title(title)
				.contents(contents)
				.writer(writer)
				.build();
	}
}
