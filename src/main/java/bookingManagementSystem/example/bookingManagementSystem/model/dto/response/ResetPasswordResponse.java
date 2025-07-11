package bookingManagementSystem.example.bookingManagementSystem.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordResponse {
    private String name;
    private String email;
    private LocalDateTime createAt = LocalDateTime.now();

}
