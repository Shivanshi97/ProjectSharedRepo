package com.ama.entities;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Booking extends BaseEntity{

	
	@OneToOne
	@JoinColumn(name = "service_Name", insertable = false, updatable = false, nullable = false)
	private Service serviceName;
	
	@OneToOne
	@JoinColumn(name = "service_id", insertable = false, updatable = false, nullable = false)
	private Service serviceId;
	
	@OneToOne
	@JoinColumn(name = "provider_id", insertable = false, updatable = false, nullable = false)
	private ServiceProvider providerId;
	@OneToOne
	@JoinColumn(name = "provider_Name", insertable = false, updatable = false, nullable = false)
	private ServiceProvider providerName;
	@Column(name = "booking_date")
	private LocalDate bookingDate;
	@Enumerated(EnumType.STRING)
	@Column
	private Status status;
	@Column(name = "start_time")
	private LocalTime startTime;
	@Column(name = "end_time")
	private LocalTime endTime;
}
