package racingcar.model;

public class Identification {
    private final String name;

    Identification(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalStateException(String.format("[ERROR]: %s is not suitable for car name", name));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
