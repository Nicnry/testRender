package com.example.eventbooking.event_booking.service;

import com.example.eventbooking.event_booking.entity.Reservation;
import com.example.eventbooking.event_booking.repository.ReservationRepository;
import com.example.eventbooking.event_booking.exception.ReservationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    // Injection par constructeur
    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Méthode pour récupérer un utilisateur par son ID
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                             .orElseThrow(() -> new ReservationNotFoundException("Reservation not found with id: " + id));
    }

    public Iterable<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
