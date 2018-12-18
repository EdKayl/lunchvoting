package ru.kayl.lunchvoting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import ru.kayl.lunchvoting.model.AbstractBaseEntity;
import ru.kayl.lunchvoting.service.CommonService;

public class AbstractController<E extends AbstractBaseEntity, S extends CommonService<E>> implements CommonController<E> {

    private final S service;

    @Autowired
    public AbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<E> save(E entity) {
        return null;
    }
}
