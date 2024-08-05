package com.ama.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{

	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String address;
	@Column(name = "phone_no", unique = true, nullable = false)
	private int phoneNo;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	//Constructor
	
	public User(String name) {
		this.name = name;
	}
	
	public User(String email,  String password) {
		this.email = email;
		this.password = password;
	}
	
}
