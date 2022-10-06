package racingcar.model;


import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ConstantNumber;

public class CarPosition {
    private final List<String> position;

    CarPosition() {
        this.position = new ArrayList<>();
    }

    public List<String> getPosition() {
        return position;
    }

    public List<String> modifyPosition(GameNumber gameNumber) {
        if (gameNumber.getNumber() >= ConstantNumber.BORDER_NUMBER) {
            position.add("-");
        }
        return this.position;
    }
}
