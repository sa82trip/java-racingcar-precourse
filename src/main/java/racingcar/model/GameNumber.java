package racingcar.model;


import racingcar.constant.ConstantNumber;
import racingcar.constant.InfoMessage;

public class GameNumber {
    private final int number;

    GameNumber(int number) {
        if (number < ConstantNumber.RANDOM_NUMBER_RANGE_BEGIN || number > ConstantNumber.RANDOM_NUMBER_RANGE_END) {
            throw new IllegalArgumentException(
                    String.format("%s: %s is not valid", InfoMessage.ERROR_MESSAGE_BEGIN.label(), number));
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
