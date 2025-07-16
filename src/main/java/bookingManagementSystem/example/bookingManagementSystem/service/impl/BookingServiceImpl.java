package bookingManagementSystem.example.bookingManagementSystem.service.impl;

import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.BookingRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.BookingResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.entity.Booking;
import bookingManagementSystem.example.bookingManagementSystem.constant.OrderStatus;
import bookingManagementSystem.example.bookingManagementSystem.model.entity.User;
import bookingManagementSystem.example.bookingManagementSystem.repository.BookingRepository;
import bookingManagementSystem.example.bookingManagementSystem.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public BookingResponse createBooking(BookingRequest request) {
        User user = User.builder()
                .id(request.getUserId())
                .build();

        Booking booking = Booking.builder()
                .id(UUID.randomUUID())
                .user(user)
                .roomName(request.getRoomName())
                .bookingDate(request.getBookingDate())
                .status(String.valueOf(OrderStatus.PENDING))
                .createAt(LocalDateTime.now())
                .build();

        bookingRepository.save(booking);

        return new BookingResponse(
                booking.getId(),
                booking.getRoomName(),
                booking.getBookingDate(),
                booking.getStatus(),
                booking.getCreateAt()
        );
    }
}
