package com.webteam.marathon.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Marathon {
	private int marathonId;
	private String marathonName;
	private int marathonMaxNum;
	private Date marathonDate;
}
