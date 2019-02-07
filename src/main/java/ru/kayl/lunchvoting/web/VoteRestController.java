package ru.kayl.lunchvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kayl.lunchvoting.model.Menu;
import ru.kayl.lunchvoting.model.User;
import ru.kayl.lunchvoting.model.Vote;
import ru.kayl.lunchvoting.service.MenuService;
import ru.kayl.lunchvoting.service.UserService;
import ru.kayl.lunchvoting.service.VoteService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@RestController
@RequestMapping(value = "/rest/vote", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    private final LocalTime END_VOTE_TIME = LocalTime.of(22, 00);
    private final LocalDate NOW_DATE = LocalDate.of(2018, 12, 1);

    @Autowired
    private VoteService voteService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/{id}")
    public ResponseEntity<String> save(@PathVariable("id") Long menuId) {

        Long userId = SecurityUtil.authUserId();

        if(LocalTime.now().isAfter(END_VOTE_TIME)) return new ResponseEntity<> ("Too late", HttpStatus.BAD_REQUEST);

        Optional<Menu> menu = menuService.findById(menuId);
        if(!menu.isPresent()) return new ResponseEntity<>("Wrong menu ID", HttpStatus.BAD_REQUEST);

        User currentUser = userService.findById(userId).get();
        //check whether the user voted today
        voteService.findByUserAndVoteDate(currentUser, NOW_DATE)
                .ifPresent(vote -> voteService.delete(vote));

        Vote newVote = new Vote(menu.get(), currentUser, NOW_DATE);
        voteService.save(newVote);

        return ResponseEntity.ok("Vote saved.");
    }

    @GetMapping
    public Vote getUserVote() {
        Long userId = SecurityUtil.authUserId();
        User currentUser = userService.findById(userId).get();

        return voteService.findByUserAndVoteDate(currentUser, NOW_DATE).get();
    }
}
