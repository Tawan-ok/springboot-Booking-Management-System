package bookingManagementSystem.example.bookingManagementSystem.service;

import bookingManagementSystem.example.bookingManagementSystem.constant.AccessRole;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.LoginRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.RegisterRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.AuthResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.entity.User;
import bookingManagementSystem.example.bookingManagementSystem.repository.UserRepository;
import bookingManagementSystem.example.bookingManagementSystem.util.JwtUtil;
import bookingManagementSystem.example.bookingManagementSystem.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);
    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    JwtUtil jwtUtil;

    @InjectMocks
    UserServiceImpl userService;


    RegisterRequest registerRequest;
    LoginRequest loginRequest;
    List<User> users = new ArrayList<>();

    @BeforeEach
    void  setUp() {
        registerRequest = new RegisterRequest();
        registerRequest.setName("John");
        registerRequest.setEmail("test01@hotmail.com");
        registerRequest.setPassword("pass");

        loginRequest = new LoginRequest();
        loginRequest.setEmail(registerRequest.getEmail());
        loginRequest.setPassword(registerRequest.getPassword());


      var user1 = User.builder()
               .id(UUID.randomUUID())
               .name(registerRequest.getName())
               .email(registerRequest.getEmail())
               .password("encoded")
               .role(String.valueOf(AccessRole.USER))
               .createAt(LocalDateTime.now())
               .build();

        var user2 = User.builder()
                .id(UUID.randomUUID())
                .name("test02")
                .email("test02@hotmail.com")
                .password("encoded")
                .role(String.valueOf(AccessRole.USER))
                .createAt(LocalDateTime.now())
                .build();

        users.add(user1);
        users.add(user2);


    }

    @Test
    void registerShouldSaveUserAndSuccess() {
        when(passwordEncoder.encode(registerRequest.getPassword())).thenReturn("encoded");
        when(userRepository.save(any())).thenReturn(users.getFirst());
        when(jwtUtil.generateToken(any())).thenReturn("token");

        AuthResponse response = userService.register(registerRequest);

        assertEquals("token", response.getToken());
        assertEquals("USER", response.getRole());
        assertEquals("test01@hotmail.com", response.getEmail());

    }

    @Test
    void getAllUsersShouldSuccess() {
        when(userRepository.findAll()).thenReturn(users);

        List<User> response = userService.getUsers();
        
        assertEquals(2, response.size());
        assertEquals("test01@hotmail.com", response.getFirst().getEmail());
    }

}