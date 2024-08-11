package com.ama.entities;

import java.time.LocalDate;

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
@Table(name = "reviews")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Review extends BaseEntity{

	@OneToOne
	@JoinColumn(name = "booking_id", insertable = false, updatable = false, nullable = false)
	private Booking bookingId;
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false, nullable = false)
	private User customerId;
	@Column
	private int rating;
	@Column
	private String comment;
	@Column(name = "review_date")
	private LocalDate reviewdate;
	
	
	
	
}
