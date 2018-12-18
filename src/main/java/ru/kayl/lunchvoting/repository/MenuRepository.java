package ru.kayl.lunchvoting.repository;

import org.springframework.stereotype.Repository;
import ru.kayl.lunchvoting.model.Menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository("menuRepository")
public interface MenuRepository extends CommonRepository<Menu> {

    public List<Menu> findAllByDate(LocalDate date);
}
