package ru.kayl.lunchvoting.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.kayl.lunchvoting.model.AbstractBaseEntity;

public interface CommonController<E extends AbstractBaseEntity> {

    @PostMapping
    ResponseEntity<E> save(@RequestBody E entity);
}
