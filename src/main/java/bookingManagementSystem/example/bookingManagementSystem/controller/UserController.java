package bookingManagementSystem.example.bookingManagementSystem.controller;

import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.RegisterRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.ResetPasswordRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.AuthResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.ResetPasswordResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface UserController {
    ResponseEntity<List<User>> getUsers();
    ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request);
    ResponseEntity<ResetPasswordResponse> resetPassword(@PathVariable UUID id, @RequestBody ResetPasswordRequest request);
}
