package bookingManagementSystem.example.bookingManagementSystem.service.impl;

import bookingManagementSystem.example.bookingManagementSystem.constant.AccessRole;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.RegisterRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.ResetPasswordRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.UserUpdateRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.AuthResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.ResetPasswordResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.UserUpdateResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.entity.User;
import bookingManagementSystem.example.bookingManagementSystem.repository.UserRepository;
import bookingManagementSystem.example.bookingManagementSystem.service.UserService;
import bookingManagementSystem.example.bookingManagementSystem.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public List<User> getUsers() {
        return userRepository.findAll();
    }


    public AuthResponse register(RegisterRequest request) {
        if (request == null ||
                request.getEmail() == null ||
                request.getPassword() == null ||
                request.getName() == null) {
            throw new IllegalArgumentException("Missing required fields");
        }

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        var user = User.builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .createAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
        var token = jwtUtil.generateToken(user);
        return new AuthResponse(token, String.valueOf(AccessRole.USER), user.getEmail());
    }

    public ResetPasswordResponse resetPassword(UUID id, ResetPasswordRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Optional.ofNullable(request.getEmail()).ifPresent(user::setEmail);
        Optional.ofNullable(request.getPassword())
                .ifPresent(password -> user.setPassword(passwordEncoder.encode(password)));

        userRepository.save(user);

        return new ResetPasswordResponse(user.getName(), user.getEmail(), user.getCreateAt());
    }

    public UserUpdateResponse updateUser(UUID id, UserUpdateRequest request) {

        User user = userRepository.findById(id).orElseThrow();

        Optional.ofNullable(request.getName()).ifPresent(user::setName);
        Optional.ofNullable(request.getEmail()).ifPresent(user::setEmail);
         userRepository.save(user);

         return new UserUpdateResponse(user.getName(), user.getEmail());
    }


}
