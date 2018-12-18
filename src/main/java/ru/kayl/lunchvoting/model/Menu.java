package ru.kayl.lunchvoting.model;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "menu")
public class Menu extends AbstractBaseEntity{

    @Column(name = "menu_date")
    @DateTimeFormat
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Restaurant restaurant;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Dish> dishes;

    public Menu() {
    }

    public Menu(Long id, LocalDate date, Restaurant restaurant, List<Dish> dishes) {
        super(id);
        this.date = date;
        this.restaurant = restaurant;
        this.dishes = dishes;
    }

    public Menu(LocalDate date, Restaurant restaurant, List<Dish> dishes) {
        this(null, date, restaurant, dishes);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Menu{ id=" + id +
                " restaurant= " + restaurant.getName() +
                " date=" + date + "}";
    }
}
