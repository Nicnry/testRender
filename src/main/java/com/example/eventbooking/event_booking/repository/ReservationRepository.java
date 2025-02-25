package com.example.eventbooking.event_booking.repository;

import com.example.eventbooking.event_booking.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // La méthode findById est déjà fournie par JpaRepository, donc elle n'est pas nécessaire ici
    
}
