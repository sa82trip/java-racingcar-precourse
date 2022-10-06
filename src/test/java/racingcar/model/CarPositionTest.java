package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarPositionTest {

    @Test
    @DisplayName("0보다 크거나 같고 4미만은 숫자는 포지션이 바뀌지 않는다")
    void modifyPosition_fail() {
        CarPosition position = new CarPosition();
        assertAll(
                () -> assertThat(position.modifyPosition(new GameNumber(0))).hasSize(0),
                () -> assertThat(position.modifyPosition(new GameNumber(3))).hasSize(0)
        );

    }

    @Test
    @DisplayName("4이상의 숫자는 포지션이 1 바뀐다")
    void modifyPosition_success() {
        CarPosition position = new CarPosition();
        assertAll(
                () -> assertThat(position.modifyPosition(new GameNumber(4))).hasSize(1),
                () -> assertThat(position.modifyPosition(new GameNumber(9))).hasSize(2)
        );

    }
}