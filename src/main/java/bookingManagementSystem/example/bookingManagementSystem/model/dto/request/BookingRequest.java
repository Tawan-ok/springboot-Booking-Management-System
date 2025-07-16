package bookingManagementSystem.example.bookingManagementSystem.model.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
public class BookingRequest {
    private UUID userId;
    private String roomName;
    private LocalDate bookingDate;
}
