package bookingManagementSystem.example.bookingManagementSystem.controller.impl;

import bookingManagementSystem.example.bookingManagementSystem.controller.AdminController;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.RegisterRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.AuthResponse;
import bookingManagementSystem.example.bookingManagementSystem.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminControllerImpl implements AdminController {
    private final AdminService adminService;

    @PostMapping("/register")
   public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(adminService.register(request));
    }

}

