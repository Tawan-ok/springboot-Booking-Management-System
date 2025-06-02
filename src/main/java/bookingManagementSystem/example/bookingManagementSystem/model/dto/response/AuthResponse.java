package bookingManagementSystem.example.bookingManagementSystem.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthResponse {
    private String token;
    private String role;
    private String email;
}
