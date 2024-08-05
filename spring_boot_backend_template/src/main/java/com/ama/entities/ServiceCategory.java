package com.ama.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "service_categories")
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString

public class ServiceCategory extends BaseEntity{

	@Column(name = "category_name",unique = true, nullable = false)
	private String categoryName;
	
//	public ServiceCategory(String categoryName) {
//		super();
//		this.categoryName = categoryName;
//	}
	
	public ServiceCategory(String categoryName) {
		this.categoryName = categoryName;
	}
}
