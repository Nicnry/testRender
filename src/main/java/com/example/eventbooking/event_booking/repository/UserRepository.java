package com.example.eventbooking.event_booking.repository;

import com.example.eventbooking.event_booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // La méthode findById est déjà fournie par JpaRepository, donc elle n'est pas nécessaire ici
}
