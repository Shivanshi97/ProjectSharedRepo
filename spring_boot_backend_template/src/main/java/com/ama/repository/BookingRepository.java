package com.ama.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ama.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

	Optional<Booking> findById(Booking bookingId);

}
