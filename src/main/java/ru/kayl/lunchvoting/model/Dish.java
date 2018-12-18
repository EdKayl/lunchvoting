package ru.kayl.lunchvoting.model;

import javax.persistence.*;

@Entity
@Table(name = "dish")
public class Dish extends AbstractNamedEntity {

    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public Dish() {
    }

    public Dish(Long id, String name, Integer price, Menu menu) {
        super(id, name);
        this.price = price;
        this.menu = menu;
    }

    public Dish(String name, Integer price, Menu menu) {
       this(null, name, price, menu);
    }

    @Override
    public String toString() {
        return "Dish{ id= " + id + ", name=" + name + ", price=" + price + "}";
    }
}
