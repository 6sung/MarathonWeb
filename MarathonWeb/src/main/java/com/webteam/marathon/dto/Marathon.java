package com.webteam.marathon.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Marathon {
	private int marathonId;
	private String marathonName;
	private int marathonMaximum;
	private Date marathonDate;
	private String marathonImg;
}
