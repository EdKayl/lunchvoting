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
    void getAllTest() {
        repository.findAll().forEach(System.out::println);
    }

    @Test
    void getByDateTest() {
        LocalDate currentDate = LocalDate.of(2018, 12, 1);
        repository.getByDate(currentDate).ifPresent(votes -> votes.forEach(System.out::println));
    }

    @Test
    void findByUserIdAndVoteDateTimeBetween() {

    }
}