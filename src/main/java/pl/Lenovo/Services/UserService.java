package pl.Lenovo.Services;

import pl.Lenovo.Entity.User;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
}
