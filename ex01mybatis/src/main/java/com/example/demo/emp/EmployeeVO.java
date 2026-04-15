package com.example.demo.emp;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

//파스칼케이스   BackgroundColor 	클래스이름
//스네이크케이스 background_color	데이터베이스
//케밥케이스     background-color	css
//카멜케이스 	 backgroundColor	필드, 메서드
@Data
public class EmployeeVO {
	// 필드
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	private Double salary;
	private Double commissionPct;
	private Integer managerId;
	private Integer departmentId;
	 
	// 생성자
	
	// 메소드

}
