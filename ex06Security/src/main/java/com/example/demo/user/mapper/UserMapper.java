package com.example.demo.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.user.service.UserVO;

@Mapper // mapperscan을 설정해줬다면 굳이 어노테이션 적을 필요 없음
public interface UserMapper {
	UserVO selectOne(String loginId);
	List<String> selectRole(Long id);
}
