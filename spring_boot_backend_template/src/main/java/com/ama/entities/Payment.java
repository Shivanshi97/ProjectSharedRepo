package com.ama.entities;

import java.time.LocalDate;

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
@Table(name = "payments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Payment extends BaseEntity{
	
	@OneToOne
	@JoinColumn(name = "booking_id", insertable = false, updatable = false, nullable = false)
	private Booking bookingId;
	@Enumerated(EnumType.STRING)
	@Column
	private Mode mode; 
	@Column
	private double amount;
	@Column(name = "payment_date")
	private LocalDate paymentDate;
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_status")
	private PaymentStatus payStatus;
}
