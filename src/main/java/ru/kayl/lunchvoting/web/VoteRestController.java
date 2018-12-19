package ru.kayl.lunchvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kayl.lunchvoting.model.Vote;
import ru.kayl.lunchvoting.service.VoteService;

import java.util.List;

@Controller
@RequestMapping(value = "/rest/vote")
public class VoteRestController {
    @Autowired
    private VoteService service;

    @PostMapping(value = "/{id}")
    public void save() {

    }

    @GetMapping
    public List<Vote> getAll() {
        List<Vote> votes = service.findAll();
        return votes;
    }
}
