package com.example.demo.board.service;

import com.github.pagehelper.PageInfo;

public interface BoardService {
	
	PageInfo<BoardVO> selectAll(BoardVO bd, int pageNum);
	BoardVO selectOne(int bno);
	int insert(BoardVO bd);
	int update(BoardVO bd);
	int delete(int bno);
}