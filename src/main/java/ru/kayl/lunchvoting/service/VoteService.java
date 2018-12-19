package ru.kayl.lunchvoting.service;

import org.springframework.stereotype.Service;
import ru.kayl.lunchvoting.model.Vote;
import ru.kayl.lunchvoting.repository.VoteRepository;

@Service
public class VoteService extends AbstractService<Vote, VoteRepository> {

    public VoteService(VoteRepository repository) {
        super(repository);
    }
}
