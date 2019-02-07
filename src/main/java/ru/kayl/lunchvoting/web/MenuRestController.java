package ru.kayl.lunchvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kayl.lunchvoting.model.Menu;
import ru.kayl.lunchvoting.service.MenuService;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(value = "/rest/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuRestController {

    @Autowired
    private MenuService service;

    @GetMapping
    public List<Menu> getAll() {
        LocalDate currentDate = LocalDate.of(2018, 12, 1);
        return service.getAllByDate(currentDate).get();
    }

}
