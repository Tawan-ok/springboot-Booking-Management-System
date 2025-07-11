package bookingManagementSystem.example.bookingManagementSystem.controller;

import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.RegisterRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AdminController {
    ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request);
}
