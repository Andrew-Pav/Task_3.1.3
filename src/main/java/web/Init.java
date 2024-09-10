package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.models.Role;
import web.models.User;
import web.service.UserService;

import java.util.Set;

@Component
public class Init {

    @Autowired
    public Init(UserService userService) {
        Role roleUser = new Role(1L, "ROLE_USER");
        Role roleAdmin = new Role(2L, "ROLE_ADMIN");
        User user = new User(1L, "user", "user", 1, "user", Set.of(roleUser));
        User admin = new User(2L, "admin", "admin", 1, "admin", Set.of(roleUser, roleAdmin));

        userService.saveUser(user);
        userService.saveUser(admin);
    }
}
