package ru.kayl.lunchvoting;


import ru.kayl.lunchvoting.model.User;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private Long id;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        this.id = user.getId();
    }

    public Long getId() {
        return id;
    }
}