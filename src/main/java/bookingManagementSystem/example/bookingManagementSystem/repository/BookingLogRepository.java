package bookingManagementSystem.example.bookingManagementSystem.repository;

import bookingManagementSystem.example.bookingManagementSystem.model.entity.BookingLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BookingLogRepository extends JpaRepository<BookingLog, UUID> {
}
