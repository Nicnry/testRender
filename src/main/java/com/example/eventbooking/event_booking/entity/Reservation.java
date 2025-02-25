package com.example.eventbooking.event_booking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;  // Liaison avec l'entité User

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    private Event event;  // Liaison avec l'entité Event

    @Column(name = "reservation_date", nullable = false, updatable = false)
    private LocalDateTime reservationDate = LocalDateTime.now();  // Date de réservation, par défaut à l'heure actuelle

    @Column(nullable = false)
    private int seats;  // Nombre de sièges réservés

    @Column(nullable = false)
    private String status = "PENDING";  // Statut de la réservation, par défaut "PENDING"

    // Constructeurs
    public Reservation() {}

    public Reservation(User user, Event event, int seats) {
        this.user = user;
        this.event = event;
        this.seats = seats;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", event=" + event +
                ", reservationDate=" + reservationDate +
                ", seats=" + seats +
                ", status='" + status + '\'' +
                '}';
    }
}
