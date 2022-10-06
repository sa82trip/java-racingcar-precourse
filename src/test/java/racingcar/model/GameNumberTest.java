package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameNumberTest {
    @Test
    void lessThanZeroShouldThrowException() {
        assertThatThrownBy(() ->
                new GameNumber(-1)
        ).isInstanceOf(IllegalArgumentException.class).hasMessageStartingWith("[ERROR]");
    }
}