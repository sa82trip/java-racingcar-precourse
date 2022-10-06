package racingcar.model;

public class Car {
    private final Identification name;

    public Car(Identification name) {
        this.name = name;
    }

    public Identification getName() {
        return name;
    }
}
