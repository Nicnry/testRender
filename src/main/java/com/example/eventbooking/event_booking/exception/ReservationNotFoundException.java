package com.example.eventbooking.event_booking.exception;

public class ReservationNotFoundException extends RuntimeException {
    
    public ReservationNotFoundException(String message) {
        super(message);
    }
}
