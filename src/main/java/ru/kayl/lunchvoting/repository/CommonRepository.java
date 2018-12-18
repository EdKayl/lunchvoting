package ru.kayl.lunchvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.kayl.lunchvoting.model.AbstractBaseEntity;

public interface CommonRepository<E extends AbstractBaseEntity> extends JpaRepository<E, Long> {
}
