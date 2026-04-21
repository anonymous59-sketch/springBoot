package com.example.demo.slip.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlipVO {
	private Long slipNo;
	private Long slipAmount;
	private String slipDt;
	private String salDt;
	private String customer;
	private String bankAcct;
}
