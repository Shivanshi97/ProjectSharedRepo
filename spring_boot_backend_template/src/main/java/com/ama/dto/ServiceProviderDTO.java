package com.ama.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceProviderDTO extends BaseDTO{

	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private Long providerId;
	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private String providerName;
	private String bio;
	private int rating;
	private String serviceLocation;
	private String avilability;
}
