package bookingManagementSystem.example.bookingManagementSystem.model.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}
