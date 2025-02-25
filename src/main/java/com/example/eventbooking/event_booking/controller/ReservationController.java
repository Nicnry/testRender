package com.example.eventbooking.event_booking.controller;

import com.example.eventbooking.event_booking.entity.Reservation;
import com.example.eventbooking.event_booking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;

    // Route pour récupérer tous les utilisateurs
    @GetMapping
    public ResponseEntity<Iterable<Reservation>> getAllReservations() {
        // Appel du service pour récupérer tous les utilisateurs
        Iterable<Reservation> reservations = reservationService.getAllReservations();

        // Retourner la liste des utilisateurs sous forme de réponse JSON (code 200)
        return ResponseEntity.ok(reservations);
    }

    // Route pour récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id) {
        // Appel du service pour récupérer l'utilisateur par son ID
        Reservation reservation = reservationService.getReservationById(id);

        // Retourner l'utilisateur sous forme de réponse JSON (code 200)
        return ResponseEntity.ok(reservation);
    }
}
