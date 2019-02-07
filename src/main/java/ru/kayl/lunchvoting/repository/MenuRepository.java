package ru.kayl.lunchvoting.repository;

import org.springframework.stereotype.Repository;
import ru.kayl.lunchvoting.model.Menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MenuRepository extends CommonRepository<Menu> {

    public Optional<List<Menu>> findAllByDate(LocalDate date);
}
