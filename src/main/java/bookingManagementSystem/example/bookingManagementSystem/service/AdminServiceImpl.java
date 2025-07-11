package bookingManagementSystem.example.bookingManagementSystem.service;

import bookingManagementSystem.example.bookingManagementSystem.constant.AccessRole;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.RegisterRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.AuthResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.entity.User;
import bookingManagementSystem.example.bookingManagementSystem.repository.UserRepository;
import bookingManagementSystem.example.bookingManagementSystem.util.JwtUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponse register(RegisterRequest request) {
        var admin = User.builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .createAt(LocalDateTime.now())
                .build();

        userRepository.save(admin);

        var token = jwtUtil.generateToken(admin);

        return new AuthResponse(token, String.valueOf(AccessRole.ADMIN), admin.getEmail());

    }

}
