package bookingManagementSystem.example.bookingManagementSystem.service;

import bookingManagementSystem.example.bookingManagementSystem.model.entity.User;
import bookingManagementSystem.example.bookingManagementSystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import net.spy.memcached.MemcachedClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MemcachedClient memcachedClient;

    private static final String USERS_CACHE_KEY = "users";

    public List<User> getUsers(){
        List<User> cached = (List<User>) memcachedClient.get(USERS_CACHE_KEY);
        if (cached != null){
            return cached;
        }
        List<User> users = userRepository.findAll();
        memcachedClient.set(USERS_CACHE_KEY, 300, users);
        return users;
    }

}
