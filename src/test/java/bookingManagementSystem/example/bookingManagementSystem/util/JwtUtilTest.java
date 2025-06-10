package bookingManagementSystem.example.bookingManagementSystem.util;

import bookingManagementSystem.example.bookingManagementSystem.model.entity.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilTest {

    @Test
    void generateTokenAndValidate() {
        JwtUtil jwtUtil = new JwtUtil();
        User user = User.builder()
                .id(UUID.randomUUID())
                .name("John")
                .email("john@example.com")
                .password("secret")
                .role("USER")
                .createAt(LocalDateTime.now())
                .build();

        String token = jwtUtil.generateToken(user);
        assertNotNull(token);

        assertEquals(user.getEmail(), jwtUtil.extractEmail(token));
        assertTrue(jwtUtil.isTokenValid(token, user.getEmail()));
        assertFalse(jwtUtil.isTokenExpired(token));
    }

    @Test
    void tokenWithWrongEmailIsInvalid() {
        JwtUtil jwtUtil = new JwtUtil();
        User user = User.builder()
                .id(UUID.randomUUID())
                .name("John")
                .email("john@example.com")
                .password("secret")
                .role("USER")
                .createAt(LocalDateTime.now())
                .build();
        String token = jwtUtil.generateToken(user);

        assertFalse(jwtUtil.isTokenValid(token, "wrong@example.com"));
    }
}
