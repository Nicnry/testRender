package com.example.eventbooking.event_booking.service;

import com.example.eventbooking.event_booking.entity.User;
import com.example.eventbooking.event_booking.repository.UserRepository;
import com.example.eventbooking.event_booking.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Injection par constructeur
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Méthode pour récupérer un utilisateur par son ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                             .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
