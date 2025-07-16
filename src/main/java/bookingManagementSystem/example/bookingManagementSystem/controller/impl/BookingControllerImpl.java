package bookingManagementSystem.example.bookingManagementSystem.controller.impl;

import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.BookingRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.BookingResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.entity.Booking;
import bookingManagementSystem.example.bookingManagementSystem.service.impl.BookingServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingControllerImpl {
    private final BookingServiceImpl bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@RequestBody @Valid BookingRequest request) {
        return ResponseEntity.ok(bookingService.createBooking(request));
    }

}
