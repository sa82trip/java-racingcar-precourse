package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차의 이름이 5자가 넘는 경우 IllegalStateException Exception 발생")
    void invalidName() {
        assertThatThrownBy(() ->
                new Car(new Identification("christophe"))
        ).isInstanceOf(IllegalStateException.class).hasMessageStartingWith("[ERROR]:");
    }

    @Test
    @DisplayName("자동차의 이름이 1~5자 사이라면 정상계")
    void validName() {
        assertAll(
                () -> assertThat(new Car(new Identification("john")).getName().getName()).contains("john"),
                () -> assertThat(new Car(new Identification("123")).getName().getName()).contains("123"),
                () -> assertThat(new Car(new Identification("john5")).getName().getName()).contains("john5")
        );
    }

    @Test
    @DisplayName("null을 보낸경우 IllegalStateException exception을 발생시킨다")
    void name_with_value_null() {
        assertThatThrownBy(() ->
                new Car(new Identification(null))
        ).isInstanceOf(IllegalStateException.class).hasMessageStartingWith("[ERROR]:");
    }

    @Test
    void move() {
        Car car = new Car(new Identification("Mike"));
        for (int i = 0; i < 5; i++) {
            car.move();
        }
        assertThat(car.getPosition().getPosition()).hasSizeBetween(0, 5);
    }

    @Test
    void move_100_times() {
        for (int i = 0; i < 100; i++) {
            move();
        }
    }
}
