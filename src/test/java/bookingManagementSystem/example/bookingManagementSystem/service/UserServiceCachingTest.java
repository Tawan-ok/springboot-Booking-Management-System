package bookingManagementSystem.example.bookingManagementSystem.service;

import bookingManagementSystem.example.bookingManagementSystem.model.entity.User;
import bookingManagementSystem.example.bookingManagementSystem.repository.UserRepository;
import net.spy.memcached.MemcachedClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceCachingTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private MemcachedClient memcachedClient;

    @InjectMocks
    private UserService userService;

    @Test
    void getUsersUsesCacheWhenAvailable() {
        List<User> users = List.of(new User());
        when(memcachedClient.get("users")).thenReturn(null).thenReturn(users);
        when(userRepository.findAll()).thenReturn(users);

        userService.getUsers();
        verify(userRepository, times(1)).findAll();
        verify(memcachedClient).set("users", 300, users);

        userService.getUsers();
        verifyNoMoreInteractions(userRepository);
    }
}
