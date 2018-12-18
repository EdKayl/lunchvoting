package ru.kayl.lunchvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.kayl.lunchvoting.model.Menu;
import ru.kayl.lunchvoting.service.MenuService;

import java.util.List;


@RestController
@RequestMapping(value = "/rest/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuRestController {

    @Autowired
    private MenuService service;

    @GetMapping
    public List<Menu> getAll() {
        return service.findAll();
    }
}
