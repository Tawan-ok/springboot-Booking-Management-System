package bookingManagementSystem.example.bookingManagementSystem.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserUpdateResponse {
    private String name;
    private String email;
}
