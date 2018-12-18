package ru.kayl.lunchvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kayl.lunchvoting.AuthorizedUser;
import ru.kayl.lunchvoting.model.User;
import ru.kayl.lunchvoting.repository.UserRepository;

@Service("userService")
public class UserService extends AbstractService <User, UserRepository> implements UserDetailsService {

    public UserService(UserRepository repository) {

        super(repository);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email.toLowerCase()).orElseThrow(() -> new UsernameNotFoundException("user with this email not found"));;
        return new AuthorizedUser(user);
    }

}
