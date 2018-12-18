package ru.kayl.lunchvoting.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.kayl.lunchvoting.MenuTestData;
import ru.kayl.lunchvoting.model.Menu;

import java.time.LocalDate;
import java.util.List;


@SpringJUnitConfig(locations = {"classpath:spring/spring-app.xml"})
class MenuRepositoryTest {
    private static int PRAGA_REST = 100000;
    private static int NEWYORK_REST = 100001;

    @Autowired
    private MenuRepository repository;

    @Test
    public void testGetAll() {
        printResult(repository.findAll());
    }

    @Test
    public void testGetAllByDate() {
        printResult(repository.findAllByDate(LocalDate.of(2018, 12, 1)));

    }

    @Test
    public void testSave() {
        repository.save(MenuTestData.MENUKIEV);
    }

    private void printResult(List<Menu> menus) {
        menus.forEach(menu -> {
            System.out.println(menu);
            System.out.println("-------");
            menu.getDishes().forEach(System.out::println);
            System.out.println("--------");
        });
    }
}