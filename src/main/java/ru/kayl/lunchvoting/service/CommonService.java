package ru.kayl.lunchvoting.service;

import ru.kayl.lunchvoting.model.AbstractBaseEntity;

import java.util.List;
import java.util.Optional;

public interface CommonService<E extends AbstractBaseEntity> {

    E save(E entity);
    List<E> findAll();
}
