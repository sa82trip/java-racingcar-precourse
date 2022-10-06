package racingcar.constant;

public enum InfoMessage {
    ERROR_MESSAGE_BEGIN("[ERROR]");

    private final String label;

    InfoMessage(String label) {
        this.label = label;
    }

    public String label() {
        return this.label;
    }
}
