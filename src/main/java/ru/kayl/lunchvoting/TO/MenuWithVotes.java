package ru.kayl.lunchvoting.TO;

import ru.kayl.lunchvoting.model.Menu;

public class MenuWithVotes {
    private Menu menu;
    private Long numOfVotes;

    public MenuWithVotes(Menu menu, Long numOfVotes) {
        this.menu = menu;
        this.numOfVotes = numOfVotes != null ? numOfVotes : 0;
    }

    public Menu getMenu() {
        return menu;
    }

    public Long getNumOfVotes() {
        return numOfVotes;
    }
}
