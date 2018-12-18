package ru.kayl.lunchvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kayl.lunchvoting.model.AbstractBaseEntity;
import ru.kayl.lunchvoting.repository.CommonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E extends AbstractBaseEntity, R extends CommonRepository<E>> implements CommonService<E> {
    protected final R repository;

    @Autowired
    public AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }
}
