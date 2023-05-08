package com.hm.board.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Board {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardNo;
	
	private String title;
	private String contents;
	private String writer;
	private int viewCount;
	
	@CreationTimestamp
	@Column(insertable = true, updatable = false)	// Insert시만 사용 
	private Timestamp createAt;
	
	@UpdateTimestamp
	private Timestamp updateAt;
	
	@Builder
    public Board(long boardNo, String title, String contents, String writer, int viewCount) {
		this.boardNo = boardNo;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.viewCount = viewCount;
    }

	public void update(String title, String contents, String writer) {
		this.title = title;
        this.contents = contents;
        this.writer = writer;
	}
}
