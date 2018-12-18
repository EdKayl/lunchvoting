package ru.kayl.lunchvoting.repository;

import ru.kayl.lunchvoting.model.Vote;

import java.time.LocalDateTime;
import java.util.Optional;

public interface VoteRepository extends CommonRepository<Vote> {
    public Optional<Vote> findByUserIdAndVoteDateTimeBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);
}
