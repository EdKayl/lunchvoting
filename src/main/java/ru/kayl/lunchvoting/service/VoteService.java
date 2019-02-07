package ru.kayl.lunchvoting.service;

import org.springframework.stereotype.Service;
import ru.kayl.lunchvoting.model.User;
import ru.kayl.lunchvoting.model.Vote;
import ru.kayl.lunchvoting.repository.VoteRepository;

import java.time.LocalDate;
import java.util.*;

@Service
public class VoteService extends AbstractService<Vote, VoteRepository> {

    public VoteService(VoteRepository repository) {
        super(repository);
    }


    public Optional<List<Vote>> getAllByDate(LocalDate currentDate) {
        return repository.findAllByDate(currentDate);
    }

    public Optional<Vote> findByUserAndVoteDate(User user, LocalDate localDate) {
        return repository.findByUserAndVoteDate(user, localDate);
    }
}
