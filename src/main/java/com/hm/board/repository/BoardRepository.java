package com.hm.board.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hm.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	List<Board> findByBoardNoOrderByBoardNoDesc(int boardNo);
	
	Board findByBoardNo(int boardNo);
	
	@Modifying
	@Query("update Board set viewCount =  viewCount + 1 where boardNo = :boardNo") 
	int updateView(@Param("boardNo") int boardNo);
}
