package com.example.demo.user.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO implements UserDetails {
	private Long id;
	private String loginId;
	private String password;
	private String fullName;
	private String deptName;
	
	private List<String> role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return role.stream()
				   .map(a -> new SimpleGrantedAuthority(a))
				   .collect(Collectors.toList());
	}
	
	@Override
	public String getUsername() {
		return loginId;
	}

	@Override
	public boolean isAccountNonExpired() {
		// 패스워드 변경 안하면 expired
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 로그인 실패횟수로 lock
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 휴면회원이면 false
		return true;
	}
	
	
}
