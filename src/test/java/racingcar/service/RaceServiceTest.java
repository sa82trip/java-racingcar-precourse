package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

class RaceServiceTest {

    @Test
    void createCars() {
        RaceService service = new RaceService();
        List<Car> cars = service.returnCars("John,Mike,Krist");
        assertAll(
                () -> assertThat(cars).hasSize(3),
                () -> cars.forEach(one -> assertThat("John,Mike,Krist").contains(one.getName().getName()))
        );
    }
}