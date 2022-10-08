package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
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
}