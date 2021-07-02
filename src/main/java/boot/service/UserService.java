package boot.service;

import boot.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    User findById(long id);
    void deleteById(long id);
}
