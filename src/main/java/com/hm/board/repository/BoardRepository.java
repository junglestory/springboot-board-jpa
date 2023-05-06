package com.hm.board.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{
	List<Board> findByBoardNoOrderByBoardNoDesc(int boardNo);
}
