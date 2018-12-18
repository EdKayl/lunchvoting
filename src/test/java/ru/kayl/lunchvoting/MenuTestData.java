package ru.kayl.lunchvoting;

import ru.kayl.lunchvoting.model.Dish;
import ru.kayl.lunchvoting.model.Menu;
import ru.kayl.lunchvoting.model.Restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MenuTestData {
    private static List<Dish> listDishes = new ArrayList<>();
    public static Menu MENUKIEV = new Menu(
            LocalDate.of(2018, 12, 2),
            new Restaurant("Kiev"),
            listDishes);

    public static Dish DISH1 = new Dish("Glushki", 120, MENUKIEV);
    public static Dish DISH2 = new Dish("Borshch", 150, MENUKIEV);
    public static Dish DISH3 = new Dish("Pampushki", 60, MENUKIEV);
    public static Dish DISH4 = new Dish("Smuzi", 220, MENUKIEV);
    static {
        listDishes.add(DISH1);
        listDishes.add(DISH2);
        listDishes.add(DISH3);
        listDishes.add(DISH4);
    }

}
