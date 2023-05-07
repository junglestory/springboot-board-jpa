package com.hm.board.service;

import java.util.ArrayList;
import java.util.List;
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
	
	public List<ResponseBoardDto> getBoard(RequestBoardDto boardDto) {    	
    	List<ResponseBoardDto> resultDto = new ArrayList<ResponseBoardDto>();
    			
    	try {
    		List<Board> results = null;
    		
	        if (boardDto == null || boardDto.getBoardNo() == 0) {	        	
	        	results = boardRepository.findAll();
	        } else {
	        	results = boardRepository.findByBoardNoOrderByBoardNoDesc(boardDto.getBoardNo());
	        }
	        
	        if (results != null) {
	        	for (Board board : results) {	        		
	        		ResponseBoardDto dto = new ResponseBoardDto(board);	        		
	        		resultDto.add(dto);
	        	}
	        }	        
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		
        return resultDto;
    }
	
	@Transactional
	public ResponseBoardDto detailBoard(int boardNo) {
		ResponseBoardDto dto = null;
		
    	try {
    		boardRepository.updateView(boardNo);
    		
	        dto = new ResponseBoardDto(boardRepository.findByBoardNo(boardNo));
	    } catch (Exception ex) {
	    	logger.error(ex.getMessage());
		}
    	
    	return dto;
    }
	
	
	public void createBoard(RequestBoardDto boardDto) {
    	try {
	         boardRepository.save(boardDto.toEntity());
	    } catch (Exception ex) {
	    	logger.error(ex.getMessage());
		}
    }
}