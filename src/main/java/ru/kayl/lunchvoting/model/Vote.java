package ru.kayl.lunchvoting.model;

import net.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "vote")
public class Vote extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "vote_date")
    @DateTimeFormat
    private LocalDate voteDate;

    public Vote() {
    }

    public Vote(Long id, Menu menu, User user, LocalDate voteDate) {

        super(id);
        this.menu = menu;
        this.user = user;
        this.voteDate = voteDate;
    }

    public Vote(Menu menu, User user, LocalDate voteDate) {
        this(null, menu, user, voteDate);
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(LocalDate voteDateTime) {
        this.voteDate = voteDate;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", menuID=" + menu.getId() +
                ", user=" + user.getName() +
                ", voteDate=" + voteDate +
                '}';
    }
}

