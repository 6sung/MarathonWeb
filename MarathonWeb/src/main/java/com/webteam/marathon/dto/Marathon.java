package com.webteam.marathon.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Marathon {
	private int marathonId;
	private String marathonName;
	private int marathonMaximum;
	private int marathonDate;
}
