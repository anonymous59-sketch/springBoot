package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.BoardVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> selectAll();
	BoardVO selectOne(int bno);
	int insert(BoardVO bd);
	int update(BoardVO bd);
	int delete(int bno);
}