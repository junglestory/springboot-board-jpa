package com.hm.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hm.board.dto.RequestBoardDto;
import com.hm.board.service.BoardService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping(value="/board")
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("")
	public String getBoards(HttpServletRequest request, Model model, RequestBoardDto boardDto) {
		model.addAttribute("results", boardService.getBoards(boardDto));
		
        return "board/boardList";
    }
	
	@GetMapping("detail")
	public String getBoardById(@RequestParam(required = true) int boardNo, Model model) {
		model.addAttribute("result", boardService.getBoardById(boardNo));
		
        return "board/boardDetail";
    }
	
	@GetMapping("/save")
	public String saveBoardForm() {
        return "board/boardSave";
    }
	
	@PostMapping("/save")
	public String saveBoard(RequestBoardDto boardDto) {
		boardService.saveBoard(boardDto);
		
		return "redirect:/board";
    }
	
	@PostMapping("/update")
	public String updateBoard(RequestBoardDto boardDto) {
		boardService.updateBoard(boardDto);
		
		return "redirect:/board";
    }
	
	@GetMapping("/delete")
	public String deleteBoard(@RequestParam(required = true) int boardNo) {
		boardService.deleteBoard(boardNo);
		
		return "redirect:/board";
    }
}
