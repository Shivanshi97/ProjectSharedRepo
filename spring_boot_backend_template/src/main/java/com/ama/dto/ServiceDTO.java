package com.ama.dto;

import com.ama.entities.ServiceCategory;
import com.ama.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


//servicename, providerid, providername, categoryid, categoryname, des, price, dur
@Getter
@Setter
@ToString
public class ServiceDTO extends BaseDTO{

	
	private String serviceName;
	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private Long providerId;
	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private String providerName;
	@JsonProperty(access = Access.WRITE_ONLY) //de ser only
	private Long categoryId;
	
	private String description;
	private double price;
	private int duration;
}
