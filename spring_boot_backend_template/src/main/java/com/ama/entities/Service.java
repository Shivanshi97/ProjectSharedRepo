package com.ama.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "services")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Service extends BaseEntity{

	
	@Column(name = "service_name")
	private String serviceName;
	@OneToOne
	@JoinColumn(name = "service_provider", insertable = false, updatable = false, nullable = false)
	private User providerName;
	@ManyToOne
	@JoinColumn(name = "category_id", insertable = false, updatable = false, nullable = false)
	private ServiceCategory categoryId;
	@Column
	private String description;
	@Column
	private double price;
	@Column
	private int duration;
	
	//constructor
	public Service(String serviceName) {
		super();
		this.serviceName = serviceName;
	}
	
	
	
}
