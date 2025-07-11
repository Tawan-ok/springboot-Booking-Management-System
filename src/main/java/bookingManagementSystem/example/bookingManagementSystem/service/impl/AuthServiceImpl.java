package bookingManagementSystem.example.bookingManagementSystem.service.impl;

import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.LoginRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.RegisterRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.AuthResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.entity.User;
import bookingManagementSystem.example.bookingManagementSystem.repository.UserRepository;
import bookingManagementSystem.example.bookingManagementSystem.service.AuthService;
import bookingManagementSystem.example.bookingManagementSystem.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponse register(RegisterRequest request){
            var user = User.builder()
                    .id(UUID.randomUUID())
                    .name(request.getName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .createAt(LocalDateTime.now())
                    .build();

            userRepository.save(user);
            var token = jwtUtil.generateToken(user);

            return new AuthResponse(token, user.getRole(), user.getEmail());
    }

    public AuthResponse login(LoginRequest request){
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credential"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid Exception");
        }

        var token = jwtUtil.generateToken(user);

        return new AuthResponse(token, user.getRole(), user.getEmail());

    }
}
