package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordTest {
	@Test
	public void test() {
		PasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String pw = encoder.encode("1234");
		boolean result = encoder.matches("1234", "$2a$10$re7tTQcMqNJ3mngzzBW2eu.ED3FHDTDGSGbXYSLzO./GNVGS.UAI2");
		System.out.println(result);
	}
}
