package ru.kayl.lunchvoting.repository;

import org.springframework.stereotype.Repository;
import ru.kayl.lunchvoting.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CommonRepository<User> {
    public Optional<User> findByEmail(String email);
}
