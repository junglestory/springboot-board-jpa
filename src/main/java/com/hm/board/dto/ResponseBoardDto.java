package com.hm.board.dto;

import java.sql.Timestamp;

import com.hm.board.entity.Board;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseBoardDto {
	private Long boardNo;	
	private String title;
	private String contents;
	private String writer;
	private int viewCount;
	private Timestamp createAt;
	private Timestamp updateAt;
	
	public ResponseBoardDto(Board board){
        this.boardNo = board.getBoardNo();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.writer = board.getWriter();
        this.viewCount = board.getViewCount();
        this.createAt = board.getCreateAt();
        this.updateAt = board.getUpdateAt();
    }
}
