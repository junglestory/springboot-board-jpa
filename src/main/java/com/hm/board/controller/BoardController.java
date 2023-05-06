package com.hm.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hm.board.dto.RequestBoardDto;
import com.hm.board.service.BoardService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping(value="/board")
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("")
	public String getBoard(HttpServletRequest request, Model model, RequestBoardDto boardDto) {
		model.addAttribute("results", boardService.getBoard(boardDto));
		
        return "board/boardList";
    }
}
