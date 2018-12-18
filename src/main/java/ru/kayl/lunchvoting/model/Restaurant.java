package ru.kayl.lunchvoting.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractNamedEntity {

    public Restaurant() {
    }

    public Restaurant(Long id, String name) {
        super(id, name);
    }

    public Restaurant(String name) {

        this(null, name);
    }

    @Override
    public String toString() {
        return "Restaurant { id = " + id +  " name='" + name + "}";
    }
}
