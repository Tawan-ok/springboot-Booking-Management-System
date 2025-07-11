package bookingManagementSystem.example.bookingManagementSystem.service;

import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.RegisterRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.AuthResponse;

public interface AdminService {
    AuthResponse register(RegisterRequest request);
}
