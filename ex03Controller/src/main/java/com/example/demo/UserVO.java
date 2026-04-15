package com.example.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "사용자정보")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {
	
	@Schema(description = "고유번호", example = "12345")
	@JsonIgnore
	@NotNull
	private Integer mno;
	
	@Schema(description = "사용자이름", example = "홍길동")
	@NotBlank
//	@JsonProperty("fname")
	private String firstName;

	@Schema(description = "사용자 이메일", example = "a@a.a")
	@Email
	private String email;
	
	private String lastName;
	
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date regdate;
}
