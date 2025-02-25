package com.example.eventbooking.event_booking.controller;

import com.example.eventbooking.event_booking.entity.User;
import com.example.eventbooking.event_booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Route pour récupérer tous les utilisateurs
    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        // Appel du service pour récupérer tous les utilisateurs
        Iterable<User> users = userService.getAllUsers();

        // Retourner la liste des utilisateurs sous forme de réponse JSON (code 200)
        return ResponseEntity.ok(users);
    }

    // Route pour récupérer un utilisateur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        // Appel du service pour récupérer l'utilisateur par son ID
        User user = userService.getUserById(id);

        // Retourner l'utilisateur sous forme de réponse JSON (code 200)
        return ResponseEntity.ok(user);
    }
}
