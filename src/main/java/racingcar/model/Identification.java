package racingcar.model;


import racingcar.constant.ConstantNumber;

public class Identification {
    private final String name;

    public Identification(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > ConstantNumber.MAX_LENGTH_FOR_CAR_NAME) {
            throw new IllegalArgumentException(String.format("[ERROR]: %s is not suitable for car name", name));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
