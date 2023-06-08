package ru.netology.springbootrestdemo.server;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import ru.netology.springbootrestdemo.exceptions.InvalidCredentials;
import ru.netology.springbootrestdemo.exceptions.UnauthorizedUser;
import ru.netology.springbootrestdemo.model.Authorities;
import ru.netology.springbootrestdemo.model.User;
import ru.netology.springbootrestdemo.repository.UserRepository;

import java.util.List;

@Component
public class AuthorizationService {

    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    public List<Authorities> getAuthorities(@Validated User user) {
        return getAuthorities(user.getUser(), user.getPassword());
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

}