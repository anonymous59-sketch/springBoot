package com.example.demo.location.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.location.service.LocationVO;

@Mapper

public interface LocationMapper {
	List<LocationVO> selectAll(LocationVO loc);
	LocationVO selectOne(int locid);
	int insert(LocationVO loc);
	int update(LocationVO loc);
	int delete(int locid);
}
