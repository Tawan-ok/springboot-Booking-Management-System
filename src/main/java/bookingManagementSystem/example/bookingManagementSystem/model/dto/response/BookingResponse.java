package bookingManagementSystem.example.bookingManagementSystem.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private UUID bookingId;
    private String roomName;
    private LocalDate bookingDate;
    private String status;
    private LocalDateTime createdAt;
}
