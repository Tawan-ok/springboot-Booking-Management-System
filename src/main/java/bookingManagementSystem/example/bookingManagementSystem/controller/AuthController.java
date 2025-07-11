package bookingManagementSystem.example.bookingManagementSystem.controller;

import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.LoginRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.RegisterRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthController {
    ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request);
    ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request);
}
