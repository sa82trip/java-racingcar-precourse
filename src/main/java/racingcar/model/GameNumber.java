package racingcar.model;


import racingcar.constant.ConstantNumber;
import racingcar.constant.InfoMessage;

public class GameNumber {
    private final Integer number;

    public GameNumber(int number) {
        checkGameNumber(number);
        this.number = number;
    }

    private static void checkGameNumber(int number) {
        if (number < ConstantNumber.RANDOM_NUMBER_RANGE_BEGIN || number > ConstantNumber.RANDOM_NUMBER_RANGE_END) {
            throw new IllegalArgumentException(
                    String.format("%s: %s is not valid%n", InfoMessage.ERROR_MESSAGE_BEGIN, number));
        }
    }

    private static int getIntFromString(String number) {
        return Integer.parseInt(number);
    }

    public static GameNumber of(String number) {
        try {
            return new GameNumber(getIntFromString(number));
        } catch (IllegalArgumentException e) {
            System.out.printf("%s%n", e.getMessage());
            return null;
        }
    }

    public Integer getNumber() {
        return number;
    }
}
