package com.example.demo.board.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {
	private final BoardMapper boardMapper;
	
	@Override
	public PageInfo<BoardVO> selectAll(BoardVO bd, int pageNum) {
		PageInfo<BoardVO> page = PageHelper.startPage(pageNum, 5)
				.doSelectPageInfo(() -> boardMapper.selectAll(bd));
		
		log.info("TotalCount : {}, CurrentPage : {}, PageSize : {}, IsNextPage : {}, IsPrevPage : {}, getPrePage : {}, getNextPage : {}, NavigatepageNums : {}"
				   , page.getTotal()
				   , page.getPageNum()
				   , page.getPageSize()
				   , page.isHasNextPage() 
				   , page.isHasPreviousPage()
				   , page.getPrePage()
				   , page.getNextPage()
				   , page.getNavigatepageNums());
		
		return page;
	}

	@Override
	public BoardVO selectOne(int bno) {
		return boardMapper.selectOne(bno);
	}

	@Override
	public int insert(BoardVO bd) {
		return boardMapper.insert(bd);
	}

	@Override
	public int update(BoardVO bd) {
		return boardMapper.update(bd);
	}

	@Override
	public int delete(int bno) {
		return boardMapper.delete(bno);
	}
	
}
