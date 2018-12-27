package ru.kayl.lunchvoting.service;

import org.springframework.stereotype.Service;
import ru.kayl.lunchvoting.TO.MenuWithVotes;
import ru.kayl.lunchvoting.model.Menu;
import ru.kayl.lunchvoting.model.Vote;
import ru.kayl.lunchvoting.repository.VoteRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VoteService extends AbstractService<Vote, VoteRepository> {

    public VoteService(VoteRepository repository) {
        super(repository);
    }

    public List<MenuWithVotes> getMenuWithNumOfVotes(LocalDate currentDate) {
        List<MenuWithVotes> result = new ArrayList<>();
        Optional<List<Vote>> votesList = repository.getByDate(currentDate);
        if(!votesList.isPresent()) return null;

        votesList.get().stream()
                .collect(Collectors.groupingBy(Vote::getMenu, Collectors.counting()))
                .forEach((menu, numOfVotes) -> result.add(new MenuWithVotes(menu, numOfVotes)));

        return result;
    }
}
