package ru.kayl.lunchvoting.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import ru.kayl.lunchvoting.model.User;
import ru.kayl.lunchvoting.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface VoteRepository extends CommonRepository<Vote> {

    @Query("SELECT v FROM Vote v WHERE v.voteDate = :date")
    Optional<List<Vote>> findAllByDate(@Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    Optional<Vote> findByUserAndVoteDate(User user, LocalDate localDate);
}
