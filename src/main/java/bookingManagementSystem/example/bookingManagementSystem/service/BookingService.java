package bookingManagementSystem.example.bookingManagementSystem.service;

import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.BookingRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.BookingResponse;

public interface BookingService {
    BookingResponse createBooking(BookingRequest request);
}
