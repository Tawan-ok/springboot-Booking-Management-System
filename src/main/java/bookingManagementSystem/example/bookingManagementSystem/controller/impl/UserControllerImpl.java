package bookingManagementSystem.example.bookingManagementSystem.controller.impl;

import bookingManagementSystem.example.bookingManagementSystem.controller.UserController;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.RegisterRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.request.ResetPasswordRequest;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.AuthResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.dto.response.ResetPasswordResponse;
import bookingManagementSystem.example.bookingManagementSystem.model.entity.User;
import bookingManagementSystem.example.bookingManagementSystem.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
   public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PutMapping("/resetPassword/{id}")
  public   ResponseEntity<ResetPasswordResponse> resetPassword(@PathVariable UUID id, @RequestBody ResetPasswordRequest request){
        ResetPasswordResponse user = userService.resetPassword(id, request);

        return ResponseEntity.ok(user);
    }

}

