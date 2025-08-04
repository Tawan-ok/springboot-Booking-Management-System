package bookingManagementSystem.example.bookingManagementSystem.service;

import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.RegisterRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.ResetPasswordRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.UserUpdateRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.AuthResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.ResetPasswordResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.UserUpdateResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<User> getUsers();
    AuthResponse register(RegisterRequest request);
    ResetPasswordResponse resetPassword(UUID id, ResetPasswordRequest request);
    UserUpdateResponse updateUser(UUID id, UserUpdateRequest request);
}
