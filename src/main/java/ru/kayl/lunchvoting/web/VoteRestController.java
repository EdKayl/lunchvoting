package ru.kayl.lunchvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kayl.lunchvoting.TO.MenuWithVotes;
import ru.kayl.lunchvoting.model.Vote;
import ru.kayl.lunchvoting.service.VoteService;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/vote", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    @Autowired
    private VoteService service;

    @PostMapping(value = "/{id}")
    public void save() {

    }

    @GetMapping
    public List<MenuWithVotes> getAll() {
        LocalDate currentDate = LocalDate.of(2018, 12, 1);
        return service.getMenuWithNumOfVotes(currentDate);
    }
}
