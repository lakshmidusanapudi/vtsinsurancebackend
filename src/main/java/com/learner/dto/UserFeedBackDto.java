package com.learner.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserFeedBackDto {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private List<String> checkBoxValues; 


}
