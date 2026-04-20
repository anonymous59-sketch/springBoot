package com.example.demo;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Table(name = "tbl_reply")
@Data
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rno;
	
	private Long bno;
	
	@Column(nullable = false)
	private String reply;
	
	@Column(nullable = false)
	private String replyer;
	
	@ColumnDefault("sysdate")
	@Temporal(TemporalType.DATE)
	private Timestamp reployDate;
	
	@ColumnDefault("sysdate")
	@Temporal(TemporalType.DATE)
	private Timestamp updateDate;
}
