package ru.kayl.lunchvoting.service;

import org.springframework.stereotype.Service;
import ru.kayl.lunchvoting.model.Menu;
import ru.kayl.lunchvoting.repository.MenuRepository;

import java.util.List;

@Service("menuService")
public class MenuService extends AbstractService<Menu, MenuRepository> {

    public MenuService(MenuRepository repository) {
        super(repository);
    }
}
