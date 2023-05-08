package com.hm.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.board.dto.RequestBoardDto;
import com.hm.board.dto.ResponseBoardDto;
import com.hm.board.entity.Board;
import com.hm.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final Logger logger = (Logger) LoggerFactory.getLogger(BoardService.class);	
	private final BoardRepository boardRepository;
	
	public List<ResponseBoardDto> getBoards(RequestBoardDto boardDto) {    	
    	List<ResponseBoardDto> resultDto = new ArrayList<ResponseBoardDto>();
    			
    	try {
    		List<Board> results = boardRepository.findAll();
    			        
	        if (results != null) {
	        	resultDto = results.stream().map(ResponseBoardDto::new).collect(Collectors.toList());
	        }	        
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		
        return resultDto;
    }
	
	@Transactional
	public ResponseBoardDto getBoardById(int boardNo) {
		ResponseBoardDto dto = null;
		
    	try {
    		boardRepository.updateView(boardNo);
    		
	        dto = new ResponseBoardDto(boardRepository.findByBoardNo(boardNo));
	    } catch (Exception ex) {
	    	logger.error(ex.getMessage());
		}
    	
    	return dto;
    }
	
	@Transactional
	public void saveBoard(RequestBoardDto boardDto) {
    	try {
	        boardRepository.save(boardDto.toSaveEntity());
	    } catch (Exception ex) {
	    	logger.error(ex.getMessage());
		}
    }
	
	@Transactional
	public void updateBoard(RequestBoardDto boardDto) {
    	try {	    	
	    	Board entity = boardRepository.findById(boardDto.getBoardNo()).orElseThrow();
	        entity.update(boardDto.getTitle(), boardDto.getContents(), boardDto.getWriter());	        
	    } catch (Exception ex) {
	    	logger.error(ex.getMessage());			
		}
	}
	
	@Transactional
	public void deleteBoard(long boardNo) {
    	try {    		
    		Board board = boardRepository.findById(boardNo).orElseThrow();    		
    		boardRepository.delete(board);    		
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}
}