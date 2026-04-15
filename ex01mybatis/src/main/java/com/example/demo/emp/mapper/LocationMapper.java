package com.example.demo.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.emp.LocationVO;

@Mapper

public interface LocationMapper {
	List<LocationVO> selectAll(LocationVO loc);
	LocationVO selectOne(int locid);
	int insert(LocationVO loc);
	int update(LocationVO loc);
	int delete(int locid);
}
