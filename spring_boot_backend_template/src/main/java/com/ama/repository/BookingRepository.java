package com.ama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ama.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
