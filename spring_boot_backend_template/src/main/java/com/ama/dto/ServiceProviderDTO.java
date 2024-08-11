package com.ama.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceProviderDTO extends BaseDTO{

	private Long providerId;
	private String providerName;
	private String bio;
	private int rating;
	private String serviceLocation;
	private String avilability;
}
