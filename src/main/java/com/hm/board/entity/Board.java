package com.hm.board.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Board {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardNo;
	
	private String title;
	private String contents;
	private String writer;
	private int viewCount;
	
	@Generated(GenerationTime.INSERT)				// Insert시 db의 default 값 적용 
	@Column(insertable = true, updatable = false)	// Insert시만 사용 
	private Timestamp createAt;
	
	@Generated(GenerationTime.ALWAYS)
	private Timestamp updateAt;
	
	@Builder
    public Board(int boardNo, String title, String contents, String writer) {
		this.boardNo = boardNo;
        this.title = title;
        this.contents = contents;
        this.writer = writer ;
    }
}
