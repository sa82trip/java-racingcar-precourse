package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

class RaceServiceTest {

    @Test
    void createCars() {
        RaceService service = new RaceService();
        Cars cars = service.returnCars("John,Mike,Krist");
        assertAll(
                () -> assertThat(cars.getCars()).hasSize(3),
                () -> cars.getCars().forEach(one -> assertThat("John,Mike,Krist").contains(one.getName().getName()))
        );
    }

    @Test
    void detectWinner() {
        RaceService service = new RaceService();
        Cars cars = new Cars(Arrays.asList("john", "mike", "kim", "yb"));
        cars.getCars().get(0).getPosition().setPosition(3);
        cars.getCars().get(1).getPosition().setPosition(3);
        cars.getCars().get(2).getPosition().setPosition(2);
        cars.getCars().get(3).getPosition().setPosition(1);
        Cars winners = service.detectWinner(cars);
        assertAll(
                () -> assertThat(winners.getCars()).hasSize(2),
                () -> assertThat(winners.getCars().get(0).getNameInString()).contains("john"),
                () -> assertThat(winners.getCars().get(1).getNameInString()).contains("mike")
        );

    }

    @Test
    void addCoWinner() {
        RaceService service = new RaceService();
        Cars winners = new Cars(new ArrayList<>(Collections.singletonList("john")));
        winners.getCars().get(0).getPosition().setPosition(3);
        int MAX = winners.getCars().get(0).getPositionInteger();
        Car car = new Car("mike");
        car.getPosition().setPosition(3);
        service.addCoWinner(MAX, winners, car);
        assertThat(winners.getCars().size()).isEqualTo(2);
    }

    @Test
    void getMax() {
        RaceService service = new RaceService();
        Cars winners = new Cars(new ArrayList<>());
        int MAX = 0;
        Car car = new Car("mike");
        car.getPosition().setPosition(3);
        int result = service.getMax(MAX, winners, car);
        assertThat(result).isEqualTo(3);
    }
}