package com.ama.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO extends BaseDTO{

	
	private String name;
	private String email;
	private String password;
	private String address;
	private int phoneNo;
	private String role;
}
