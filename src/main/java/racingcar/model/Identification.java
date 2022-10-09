package racingcar.model;


import racingcar.constant.ConstantNumber;
import racingcar.constant.InfoMessage;

public class Identification {
    private final String name;

    public Identification(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > ConstantNumber.MAX_LENGTH_FOR_CAR_NAME) {
            throw new IllegalArgumentException(
                    String.format("%s: %s is not suitable for car name", InfoMessage.ERROR_MESSAGE_BEGIN, name));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
