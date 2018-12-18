package ru.kayl.lunchvoting.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.kayl.lunchvoting.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:spring/spring-app.xml")
class VoteRepositoryTest {
    private static LocalDate testDate = LocalDate.of(2018, 12, 1);

    @Autowired
    VoteRepository repository;

    @Test
    void findByUserIdAndVoteDateTimeBetween() {
        Optional<Vote> vote = repository.findByUserIdAndVoteDateTimeBetween(100014l,
                LocalDateTime.of(testDate, LocalTime.MIN),
                LocalDateTime.of(testDate, LocalTime.MAX));
        System.out.println(vote.get());
    }
}