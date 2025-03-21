package com.example.eventbooking.event_booking.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/csrf")
public class CsrfController {

    @GetMapping
    public Map<String, String> getCsrfToken(HttpServletRequest request) {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());

        Map<String, String> csrf = new HashMap<>();
        if (csrfToken != null) {
            csrf.put("csrfToken", csrfToken.getToken());
        }

        return csrf;
    }
}
