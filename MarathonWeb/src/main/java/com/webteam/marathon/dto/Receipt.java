package com.webteam.marathon.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Receipt {
	private int receiptNum;
	private String userName;
	private String phoneNum;
	private String userAdd;
	private String userEmail;
	private Date userBirth;
	private int marathonId;
	private String userPassword;
}
