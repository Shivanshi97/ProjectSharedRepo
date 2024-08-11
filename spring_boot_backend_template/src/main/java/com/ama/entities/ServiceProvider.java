package com.ama.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "service_providers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ServiceProvider extends BaseEntity{

	@OneToOne
	@JoinColumn(name = "provider_id", insertable = false, updatable = false, nullable = false)
	private User providerId;
	@OneToOne
	@JoinColumn(name = "provider_Name", insertable = false, updatable = false, nullable = false)
	private User providerName;
	@Column
	private String bio;
	@Column
	private int rating;
	@Column(name = "service_location")
	private String serviceLocation;
	@Enumerated(EnumType.STRING)
	@Column
	private Availability avilability;
	
	//constructor
	public ServiceProvider(User providerName) {
		this.providerName = providerName;
	}
	
	
}
