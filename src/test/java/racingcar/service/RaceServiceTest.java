package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
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
        Car car1 = new Car("john");
        car1.getPosition().setPosition(3);
        Car car2 = new Car("mike");
        car2.getPosition().setPosition(3);
        Car car3 = new Car("kim");
        car3.getPosition().setPosition(2);
        Car car5 = new Car("yb");
        car5.getPosition().setPosition(1);
        Cars cars = new Cars(Arrays.asList(car1, car2, car3, car5));
        Cars winners = service.detectWinner(cars);
        assertAll(
                () -> assertThat(winners.getCars()).hasSize(2),
                () -> assertThat(winners.getCars().get(0).getNameInString()).contains("john"),
                () -> assertThat(winners.getCars().get(1).getNameInString()).contains("mike")
        );

    }
}