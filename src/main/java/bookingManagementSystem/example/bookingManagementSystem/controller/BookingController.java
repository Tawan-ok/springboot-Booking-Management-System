package bookingManagementSystem.example.bookingManagementSystem.controller;

import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.BookingRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.BookingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface BookingController {
    ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest request);
}
