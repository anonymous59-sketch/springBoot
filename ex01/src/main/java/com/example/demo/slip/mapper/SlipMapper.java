package com.example.demo.slip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.slip.service.SlipVO;

@Mapper
public interface SlipMapper {
	
	List<SlipVO> selectAll(SlipVO vo);
//	SlipVO selectOne(long slipNo);
	int insert(SlipVO vo);
//	int update(SlipVO vo);
//	int delete(SlipVO vo);
	
}
