package com.example.eventbooking.event_booking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    @GetMapping
    public String getEvents() {
        return "Hello from Event Booking!!";
    }
}
