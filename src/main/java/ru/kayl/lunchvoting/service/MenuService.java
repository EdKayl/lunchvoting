package ru.kayl.lunchvoting.service;

import org.springframework.stereotype.Service;
import ru.kayl.lunchvoting.model.Menu;
import ru.kayl.lunchvoting.repository.MenuRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MenuService extends AbstractService<Menu, MenuRepository> {

    public MenuService(MenuRepository repository) {
        super(repository);
    }

    public Optional<List<Menu>> getAllByDate(LocalDate currentDate) {
        return repository.findAllByDate(currentDate);
    }

}
