package bookingManagementSystem.example.bookingManagementSystem.model.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserUpdateRequest {
    private String name;
    private String email;
}
